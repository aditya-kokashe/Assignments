package assignments.assignment3;

//Write a program to demonstrate 15 methods of Vector, including all constructors.
import java.util.*;

public class Q2 {
    public static void main(String[] args) {

    	
    	// Constructors
        Vector<Integer> v1 = new Vector<>();
        //Vector<Integer> v2 = new Vector<>(10);
        //Vector<Integer> v3 = new Vector<>(10, 5);
        //Vector<Integer> v4 = new Vector<>(v1);

        // Methods
        v1.add(10);
        v1.add(20);
        v1.addElement(30);
        v1.add(1, 15);

        System.out.println(v1);

        v1.remove(1);
        v1.removeElement(30);

        System.out.println("Size: " + v1.size());
        System.out.println("Capacity: " + v1.capacity());

        System.out.println("First: " + v1.firstElement());
        System.out.println("Last: " + v1.lastElement());

        System.out.println("Contains 10: " + v1.contains(10));
        System.out.println("Index of 20: " + v1.indexOf(20));

        v1.set(0, 100);
        System.out.println("After set: " + v1);

        v1.addAll(Arrays.asList(40, 50));
        System.out.println("After addAll: " + v1);

        v1.removeAll(Arrays.asList(40));
        System.out.println("After removeAll: " + v1);

        v1.clear();
        System.out.println("After clear: " + v1);
    }
}