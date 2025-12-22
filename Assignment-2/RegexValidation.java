import java.util.Scanner;
import java.util.regex.*;

public class RegexValidation {

    static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) break;

            System.out.print("Enter input: ");
            String input = sc.nextLine();

            try {
                boolean result = false;

                switch (choice) {
                    case 1:
                        result = validate(input, "[6-9][0-9]{9}");
                        break;
                    case 2:
                        result = validate(input, "[a-zA-Z0-9._]+@[a-z]+\\.[a-z]{2,}");
                        break;
                    case 3:
                        result = validate(input, "[a-zA-Z][a-zA-Z0-9_]{4,}");
                        break;
                    case 4:
                        result = validate(input, "(?=.*[A-Z])(?=.*[0-9]).{6,}");
                        break;
                    default:
                        throw new Exception("Invalid Choice!");
                }

                if (result)
                    System.out.println("Welcome! Valid Input.");
                else
                    System.out.println("Invalid Input!");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
