/*
package IteratorsAndComparators.exercises.StrategyPattern;

import IteratorsAndComparators.exercises.StrategyPattern.IteratorsAndComparators.exercises.EqualityLogic.Person;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class IteratorsAndComparators.exercises.EqualityLogic.IteratorsAndComparators.exercises.StackIterator.Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int nPeople = Integer.parseInt(scanner.nextLine());
        Set<IteratorsAndComparators.exercises.EqualityLogic.Person> personSetByName = new TreeSet<>(new PersonNameComparator());
        Set<IteratorsAndComparators.exercises.EqualityLogic.Person> personSetByAge = new TreeSet<>(new PersonAgeComparator());

        while (nPeople-- > 0) {

            String[] data = scanner.nextLine().split("\\s");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            IteratorsAndComparators.exercises.EqualityLogic.Person person = new IteratorsAndComparators.exercises.EqualityLogic.Person(name,age);
            personSetByName.add(person);
            personSetByAge.add(person);
        }

        for (IteratorsAndComparators.exercises.EqualityLogic.Person person : personSetByName) {
            System.out.println(person);
        }

        for (IteratorsAndComparators.exercises.EqualityLogic.Person person : personSetByAge) {
            System.out.println(person);
        }

    }
}
*/
