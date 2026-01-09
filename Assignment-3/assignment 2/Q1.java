package assignments.assignment3;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
    	
    	 // Constructors
        ArrayList<String> list1 = new ArrayList<>();
        //ArrayList<String> list2 = new ArrayList<>(20);
        //ArrayList<String> list3 = new ArrayList<>(list1);

        // Methods
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");
        list1.add(1, "Spring");

        System.out.println(list1);

        list1.remove("C++");
        list1.remove(0);

        System.out.println("Size: " + list1.size());
        System.out.println("Contains Java: " + list1.contains("Java"));

        list1.set(0, "Hibernate");
        System.out.println("Get index 1: " + list1.get(1));

        System.out.println("Index of Spring: " + list1.indexOf("Spring"));

        list1.add("Java");
        System.out.println("Last Index of Java: " + list1.lastIndexOf("Java"));

        System.out.println("Is Empty: " + list1.isEmpty());

        list1.addAll(Arrays.asList("SQL", "HTML"));
        System.out.println("After addAll: " + list1);

        list1.removeAll(Arrays.asList("SQL"));
        System.out.println("After removeAll: " + list1);

        list1.retainAll(Arrays.asList("Java", "Hibernate"));
        System.out.println("After retainAll: " + list1);

        Object[] arr = list1.toArray();
        System.out.println("Array Length: " + arr.length);

        list1.clear();
        System.out.println("After clear: " + list1);
    }
}