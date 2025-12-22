import java.util.*;
import java.util.regex.*;

interface StudentOperations {
    void addStudent(Student s);
    void displayStudents();
    void searchStudent(int roll);
    void removeStudent(int roll);
}

class Student {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }
}

class StudentManager implements StudentOperations {
    List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void displayStudents() {
        for (Student s : students)
            System.out.println(s.roll + " " + s.name);
    }

    public void searchStudent(int roll) {
        for (Student s : students)
            if (s.roll == roll) {
                System.out.println("Found: " + s.name);
                return;
            }
        System.out.println("Student not found");
    }

    public void removeStudent(int roll) {
        students.removeIf(s -> s.roll == roll);
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.addStudent(new Student(1, "Aditya"));
        sm.addStudent(new Student(2, "Rahul"));

        sm.displayStudents();
        sm.searchStudent(1);
        sm.removeStudent(2);
        sm.displayStudents();
    }
}
