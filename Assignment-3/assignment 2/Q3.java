package assignments.assignment3;

//Write a program to demonstrate all constructors and 15 methods of HashMap.
import java.util.*;

public class Q3 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // Constructors
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>(20);
        HashMap<Integer, String> map3 = new HashMap<>(20, 0.75f);
        HashMap<Integer, String> map4 = new HashMap<>(map1);

        // Methods
        map1.put(1, "Java");
        map1.put(2, "Python");
        map1.put(3, "C++");

        System.out.println(map1);

        map1.putIfAbsent(4, "Spring");
        map1.remove(2);

        System.out.println("Get 1: " + map1.get(1));
        System.out.println("Contains Key 3: " + map1.containsKey(3));
        System.out.println("Contains Value Java: " + map1.containsValue("Java"));

        System.out.println("Size: " + map1.size());
        System.out.println("Is Empty: " + map1.isEmpty());

        System.out.println("Keys: " + map1.keySet());
        System.out.println("Values: " + map1.values());
        System.out.println("Entry Set: " + map1.entrySet());

        map1.replace(1, "Hibernate");
        System.out.println("After replace: " + map1);

        map1.computeIfAbsent(5, k -> "SQL");
        map1.computeIfPresent(3, (k,v) -> v + " Language");

        map1.clear();
        System.out.println("After clear: " + map1);
    }
}