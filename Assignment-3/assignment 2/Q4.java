package assignments.assignment3;

//Write a program to demonstrate all constructors and 15 methods of HashTable.
import java.util.*;

public class Q4 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // Constructors
        Hashtable<Integer, String> ht1 = new Hashtable<>();
        Hashtable<Integer, String> ht2 = new Hashtable<>(20);
        Hashtable<Integer, String> ht3 = new Hashtable<>(20, 0.75f);
        Hashtable<Integer, String> ht4 = new Hashtable<>(ht1);

        // Methods
        ht1.put(1, "Java");
        ht1.put(2, "Python");
        ht1.put(3, "C++");

        System.out.println(ht1);

        ht1.remove(2);
        System.out.println("Get 1: " + ht1.get(1));

        System.out.println("Contains Key 3: " + ht1.containsKey(3));
        System.out.println("Contains Value Java: " + ht1.containsValue("Java"));

        System.out.println("Size: " + ht1.size());
        System.out.println("Is Empty: " + ht1.isEmpty());

        System.out.println("Keys: " + ht1.keySet());
        System.out.println("Values: " + ht1.values());
        System.out.println("Entry Set: " + ht1.entrySet());

        ht1.putIfAbsent(4, "Spring");
        ht1.replace(1, "Hibernate");

        ht1.computeIfAbsent(5, k -> "SQL");

        ht1.clear();
        System.out.println("After clear: " + ht1);
    }
}