import java.util.*;

class UniversitySystem {

    static class Student {
        int id;
        String course;
        int marks;

        Student(int id, String course, int marks) {
            this.id = id;
            this.course = course;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Set<String> courses = new HashSet<>();
        HashMap<Integer, Student> studentMap = new HashMap<>();

        students.add(new Student(1, "CSE", 85));
        students.add(new Student(2, "ECE", 75));
        students.add(new Student(3, "CSE", 90));

        for (Student s : students) {
            studentMap.put(s.id, s);
            courses.add(s.course);
        }

        System.out.println("All Students:");
        for (Student s : students)
            System.out.println(s.id + " " + s.course + " " + s.marks);

        students.sort((a, b) -> b.marks - a.marks);
        System.out.println("\nSorted by Marks:");
        students.forEach(s -> System.out.println(s.id + " " + s.marks));

        TreeMap<Integer, Student> sortedMap = new TreeMap<>(studentMap);
        System.out.println("\nConverted HashMap to TreeMap");

        System.out.println("\nUnique Courses:");
        System.out.println(courses);
    }
}
