import java.util.Scanner;
class Bank {
    String name;
    int accNo;
    double balance;
    Bank(String n, int a, double b) {
        name = n;
        accNo = a;
        balance = b;
    }
    void deposit(double amt) {
        balance += amt;
    }
    void withdraw(double amt) {
        if (amt > balance) throw new ArithmeticException();
        balance -= amt;
    }
    void display() {
        System.out.println(name);
        System.out.println(accNo);
        System.out.println(balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank(sc.next(), sc.nextInt(), sc.nextDouble());
        int ch = sc.nextInt();
        try {
            if (ch == 1) b.deposit(sc.nextDouble());
            if (ch == 2) b.withdraw(sc.nextDouble());
            if (ch == 3) System.out.println(b.balance);
            if (ch == 4) b.display();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
