package Mini_Project3;
import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    String course;
    double fees;

    Student(int id, String name, String course, double fees) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fees = fees;
    }

    public String toString() {
        return id + "," + name + "," + course + "," + fees;
    }

    static Student fromFile(String line) {
        String[] p = line.split(",");
        return new Student(
                Integer.parseInt(p[0]),
                p[1],
                p[2],
                Double.parseDouble(p[3]));
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> list = new ArrayList<>();
    static final String FILE = "src/Mini_Project3/students.txt";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        load();

        while (true) {
            System.out.println("\n1 Add Student");
            System.out.println("2 Display Students");
            System.out.println("3 Search Student");
            System.out.println("4 Update Student");
            System.out.println("5 Delete Student");
            System.out.println("6 Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> add(sc);
                case 2 -> display();
                case 3 -> search(sc);
                case 4 -> update(sc);
                case 5 -> delete(sc);
                case 6 -> {
                    save();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void add(Scanner sc) throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        for (Student s : list)
            if (s.id == id) {
                System.out.println("ID already exists");
                return;
            }

        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();
        System.out.print("Fees: ");
        double fees = sc.nextDouble();

        list.add(new Student(id, name, course, fees));
        save();
        System.out.println("Student Added");
    }

    static void display() {
        for (Student s : list)
            System.out.println(s.id + " " + s.name + " " + s.course + " " + s.fees);
    }

    static void search(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : list)
            if (s.id == id) {
                System.out.println(s.id + " " + s.name + " " + s.course + " " + s.fees);
                return;
            }

        System.out.println("Student not found");
    }

    static void update(Scanner sc) throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        for (Student s : list)
            if (s.id == id) {
                sc.nextLine();
                System.out.print("New Name: ");
                s.name = sc.nextLine();
                System.out.print("New Course: ");
                s.course = sc.nextLine();
                System.out.print("New Fees: ");
                s.fees = sc.nextDouble();
                save();
                System.out.println("Updated Successfully");
                return;
            }
        System.out.println("Student not found");
    }

    static void delete(Scanner sc) throws Exception {
        System.out.print("ID: ");
        int id = sc.nextInt();

        list.removeIf(s -> s.id == id);
        save();
        System.out.println("Deleted Successfully");
    }

    static void save() throws Exception {
        FileWriter fw = new FileWriter(FILE);
        for (Student s : list)
            fw.write(s.toString() + "\n");
        fw.close();
    }

    static void load() throws Exception {
        File f = new File(FILE);
        if (!f.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;
        while ((line = br.readLine()) != null)
            list.add(Student.fromFile(line));
        br.close();
    }
}