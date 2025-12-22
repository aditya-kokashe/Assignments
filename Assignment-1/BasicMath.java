import java.util.Scanner;
class BasicMath {
    static int add(int a, int b) { return a + b; }
    static int sub(int a, int b) { return a - b; }
    static int mul(int a, int b) { return a * b; }
    static int div(int a, int b) { return a / b; }
    static int rem(int a, int b) { return a % b; }
    static int square(int a) { return a * a; }
    static int cube(int a) { return a * a * a; }
    static int abs(int a) { return Math.abs(a); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(add(a, b));
        System.out.println(sub(a, b));
        System.out.println(mul(a, b));
        System.out.println(div(a, b));
        System.out.println(rem(a, b));
        System.out.println(square(a));
        System.out.println(cube(a));
        System.out.println(abs(a));
    }
}
