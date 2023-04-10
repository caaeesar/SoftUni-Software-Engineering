package OtherProblems;

import java.util.HashMap;

public class demoCollections {
    public static void main(String[] arguments) {
        // create two hash maps
        HashMap myMap1 = new HashMap<>();
        HashMap <Integer,String> myMap2 = new HashMap <Integer,String> ();
        // populate hash maps
        myMap1.put(1, "Red");
        myMap1.put(2, "Green");
        myMap1.put(3, "Black");
        System.out.println("\nValues in first map: " + myMap1);
        myMap2.put(4, "White");
        myMap2.put(5, "Blue");
        myMap2.put(6, "Orange");
        System.out.println("\nValues in second map: " + myMap2);

        // put all values in second map
        myMap2.putAll(myMap1);
        System.out.println("\nNow values in second map: " + myMap2);
        System.out.println(myMap2.size());
        myMap1.clear();
    }
}
