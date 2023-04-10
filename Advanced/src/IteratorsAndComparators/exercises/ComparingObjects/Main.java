package IteratorsAndComparators.exercises.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String END = "END";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!END.equals(input)) {

            String[] data = input.split("\\s");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];

            Person person = new Person(name, age, town);
            people.add(person);
            input = scanner.nextLine();
        }

        int personIndex = Integer.parseInt(scanner.nextLine());
        Person person = people.get(personIndex - 1);
        people.remove(person);

        int equalPeople = 1;
        int notEqualPeople = 0;
        int totalPeople = people.size() + 1; // add main person

        for (Person currentPerson : people) {
           /* if (person.compareTo(currentPerson) == 0) {
                equalPeople++;
            } else {
                notEqualPeople++;
            }*/
            if (currentPerson.equals(person)) {
                equalPeople++;
            } else {
                notEqualPeople++;
            }
        }

        if (equalPeople == 1) { // person for compare
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d",
                    equalPeople, notEqualPeople, totalPeople);
        }
    }
}
