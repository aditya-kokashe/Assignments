package assignments.assignment3;

//Write a program to demonstrate all constructors and 15 methods of TreeMap.
import java.util.*;

public class Q5 {
    @SuppressWarnings("unused")
	public static void main(String[] args) {

        // Constructors
        TreeMap<Integer, String> tm1 = new TreeMap<>();
        TreeMap<Integer, String> tm2 = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer, String> tm3 = new TreeMap<>(tm1);
        TreeMap<Integer, String> tm4 = new TreeMap<>(Map.of(1,"A",2,"B"));

        // Methods
        tm1.put(3, "Java");
        tm1.put(1, "Python");
        tm1.put(2, "C++");

        System.out.println(tm1);

        System.out.println("First Key: " + tm1.firstKey());
        System.out.println("Last Key: " + tm1.lastKey());

        System.out.println("Higher Key than 1: " + tm1.higherKey(1));
        System.out.println("Lower Key than 3: " + tm1.lowerKey(3));

        System.out.println("Ceiling Key 2: " + tm1.ceilingKey(2));
        System.out.println("Floor Key 2: " + tm1.floorKey(2));

        System.out.println("HeadMap: " + tm1.headMap(2));
        System.out.println("TailMap: " + tm1.tailMap(2));
        System.out.println("SubMap: " + tm1.subMap(1,3));

        System.out.println("Poll First: " + tm1.pollFirstEntry());
        System.out.println("Poll Last: " + tm1.pollLastEntry());

        tm1.replace(2, "Spring");
        System.out.println("After replace: " + tm1);

        tm1.clear();
        System.out.println("After clear: " + tm1);
    }
}