import java.util.*;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> linkedList = new LinkedList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        Deque<String> deque = new ArrayDeque<>();
        Queue<String> animal = new PriorityQueue<>();

/*        deque.push("<d");
        System.out.println(deque.isEmpty());*/


        linkedList.offer(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
      /*  linkedList.remove();
        linkedList.remove();*/
     /*   System.out.println(linkedList.peek());
        Integer poll = linkedList.poll();*/
        System.out.println(linkedList);
        for (Integer n : linkedList) {
            System.out.println(n);
        }

/*

        // Creating a set using the HashSet class
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        System.out.println("Set1: " + set1);

        // Creating another set using the HashSet class
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        System.out.println("Set2: " + set2);

        */
/*//*
/ Union of two sets
        set2.addAll(set1);
        System.out.println("Union is: " + set2);*//*


        System.out.println(set2.containsAll(set1));
        //System.out.println("Intersection is: " + set2);

        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);
        System.out.println("HashSet: " + numbers);

        // Calling iterator() method
        Iterator<Integer> iterate = numbers.iterator();
        System.out.print("HashSet using Iterator: ");
        // Accessing elements
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
*/

    }
}
