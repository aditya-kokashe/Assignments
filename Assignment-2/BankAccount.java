import java.util.Scanner;

// Banking operations interface
interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount) throws Exception;
    void checkBalance();
}

// Customer details interface
interface CustomerDetails {
    void displayCustomerInfo();
}

// BankAccount class implementing multiple interfaces
class BankAccount implements BankOperations, CustomerDetails {
    private String customerName;
    private int accountNumber;
    private double balance;

    BankAccount(String name, int accNo, double balance) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient Balance!");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void displayCustomerInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Account Number: " + accountNumber);
    }

    public static void main(String[] args) {
        try {
            BankAccount acc = new BankAccount("Aditya", 101, 5000);
            acc.displayCustomerInfo();
            acc.deposit(2000);
            acc.withdraw(3000);
            acc.checkBalance();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
