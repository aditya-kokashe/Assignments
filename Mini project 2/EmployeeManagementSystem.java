package Mini_Project2;
import java.io.*;
import java.util.*;

class Employee {
	
	/*
 	* Login Credentials :
 	* Username: admin
 	* Password: 1234
 	*/
	
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + "," + name + "," + department + "," + salary;
    }

    static Employee fromString(String line) {
        String[] p = line.split(",");
        return new Employee(Integer.parseInt(p[0]), p[1], p[2], Double.parseDouble(p[3]));
    }
}

public class EmployeeManagementSystem {

    static ArrayList<Employee> list = new ArrayList<>();
    static final String FILE = "src/Mini_Project2/employees.txt";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        loadFromFile();

        System.out.println("\n=== EMPLOYEE MANAGEMENT SYSTEM ===");

        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if (!u.equals("admin") || !p.equals("1234")) {
            System.out.println("Invalid Login!");
            return;
        }

        while (true) {
        	System.out.println("----------------------------------------------------------");
            System.out.println("\n1.Add Employee\n2.Display All\n3.Search\n4.Update Salary\n5.Delete\n6.Display Sorted\n7.Display Departments\n8.Exit");
            System.out.println("----------------------------------------------------------");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addEmployee(sc);
                case 2 -> display();
                case 3 -> search(sc);
                case 4 -> updateSalary(sc);
                case 5 -> delete(sc);
                case 6 -> sortEmployees();
                case 7 -> showDepartments();
                case 8 -> { saveToFile(); System.exit(0); }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void addEmployee(Scanner sc) throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        for (Employee e : list)
            if (e.id == id) throw new Exception("Employee ID already exists");

        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String dept = sc.nextLine();
        if (dept.isEmpty()) throw new Exception("Department cannot be empty");

        System.out.print("Salary: ");
        double sal = sc.nextDouble();
        if (sal <= 0) throw new Exception("Salary must be positive");

        list.add(new Employee(id, name, dept, sal));
        saveToFile();
        System.out.println("Employee Added Successfully");
    }

    static void display() {
        for (Employee e : list)
            System.out.println(e.id + "  " + e.name + "  " + e.department + "  " + e.salary);
    }

    static void search(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : list)
            if (e.id == id) {
                System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
                return;
            }
        System.out.println("Employee Not Found");
    }

    static void updateSalary(Scanner sc) throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        for (Employee e : list) {
            if (e.id == id) {
                System.out.print("New Salary: ");
                double s = sc.nextDouble();
                if (s <= 0) throw new Exception("Salary must be positive");
                e.salary = s;
                saveToFile();
                System.out.println("Salary Updated");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    static void delete(Scanner sc) throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        list.removeIf(e -> e.id == id);
        saveToFile();
        System.out.println("Employee Deleted");
    }

    static void sortEmployees() {
        list.sort(Comparator.comparingInt(e -> e.id));
        display();
    }

    static void showDepartments() {
        HashSet<String> set = new HashSet<>();
        for (Employee e : list) set.add(e.department);
        System.out.println("Departments: " + set);
    }

    static void saveToFile() throws Exception {
        FileWriter fw = new FileWriter(FILE);
        for (Employee e : list)
            fw.write(e.toString() + "\n");
        fw.close();
    }

    static void loadFromFile() throws Exception {
        File f = new File(FILE);
        if (!f.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;
        while ((line = br.readLine()) != null)
            list.add(Employee.fromString(line));
        br.close();
    }
}