import java.io.*;
import java.util.*;

abstract class BankAccount {
    protected int accountNumber;
    protected String customerName;
    protected double balance;

    BankAccount(int accNo, String name, double bal) {
        this.accountNumber = accNo;
        this.customerName = name;
        this.balance = bal;
    }


    abstract void accountType();


    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
    }

    void deposit(double amount, String note) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount + " (" + note + ")");
    }

    // Method Overriding 
    abstract void withdraw(double amount);

    void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name      : " + customerName);
        System.out.println("Balance   : " + balance);
    }

    double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {

    SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    void accountType() {
        System.out.println("Account Type: Savings Account");
    }

    // Overriding
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}


class CurrentAccount extends BankAccount {

    CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    void accountType() {
        System.out.println("Account Type: Current Account");
    }

    // Overriding
    void withdraw(double amount) {
        balance -= amount; // overdraft allowed
        System.out.println("Withdrawn: " + amount);
    }
}


public class BankManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "accounts.txt";

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n---- BANK MANAGEMENT SYSTEM ----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> createAccount();
                    case 2 -> depositAmount();
                    case 3 -> withdrawAmount();
                    case 4 -> balanceEnquiry();
                    case 5 -> displayAccount();
                    case 6 -> System.out.println("Thank you!");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 6);
    }


    static void createAccount() throws IOException {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.print("1. Savings  2. Current : ");
        int type = sc.nextInt();

        BankAccount acc;
        if (type == 1)
            acc = new SavingsAccount(accNo, name, bal);
        else
            acc = new CurrentAccount(accNo, name, bal);

        writeToFile(acc);
        System.out.println("Account Created Successfully ✅");
    }


    static void writeToFile(BankAccount acc) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(acc.accountNumber + "," + acc.customerName + "," +
                 acc.balance + "," + acc.getClass().getSimpleName() + "\n");
        fw.close();
    }


    static List<String> readFile() throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return list;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null)
            list.add(line);
        br.close();
        return list;
    }


    static void depositAmount() throws IOException {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        updateBalance(accNo, amt);
    }


    static void withdrawAmount() throws IOException {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Amount: ");
        double amt = sc.nextDouble();

        updateBalance(accNo, -amt);
    }


    static void updateBalance(int accNo, double amt) throws IOException {
        List<String> data = readFile();
        FileWriter fw = new FileWriter(FILE_NAME);

        boolean found = false;
        for (String s : data) {
            String[] arr = s.split(",");
            int id = Integer.parseInt(arr[0]);
            double bal = Double.parseDouble(arr[2]);

            if (id == accNo) {
                bal += amt;
                found = true;
            }
            fw.write(arr[0] + "," + arr[1] + "," + bal + "," + arr[3] + "\n");
        }
        fw.close();

        if (found)
            System.out.println("Transaction Successful");
        else
            System.out.println("Account Not Found");
    }


    static void balanceEnquiry() throws IOException {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (String s : readFile()) {
            String[] arr = s.split(",");
            if (Integer.parseInt(arr[0]) == accNo) {
                System.out.println("Balance: " + arr[2]);
                return;
            }
        }
        System.out.println("Account Not Found");
    }


    static void displayAccount() throws IOException {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (String s : readFile()) {
            String[] arr = s.split(",");
            if (Integer.parseInt(arr[0]) == accNo) {
                System.out.println("Account No : " + arr[0]);
                System.out.println("Name       : " + arr[1]);
                System.out.println("Balance    : " + arr[2]);
                System.out.println("Type       : " + arr[3]);
                return;
            }
        }
        System.out.println("Account Not Found");
    }
}