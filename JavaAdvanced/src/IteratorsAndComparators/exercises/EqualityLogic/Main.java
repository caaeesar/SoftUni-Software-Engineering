package IteratorsAndComparators.exercises.EqualityLogic;

import IteratorsAndComparators.exercises.EqualityLogic.Person;

import java.util.*;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int nPeople = Integer.parseInt(scanner.nextLine());
        Set<Person> hashSet = new HashSet<>();
        Set<Person> treeSet = new TreeSet<>();

        while (nPeople-- > 0) {

            String[] data = scanner.nextLine().split("\\s");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name,age);
            hashSet.add(person);
            treeSet.add(person);
        }

        System.out.println(hashSet.size());
        System.out.println(treeSet.size());

    }
}
