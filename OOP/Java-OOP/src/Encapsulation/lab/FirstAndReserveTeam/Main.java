package Encapsulation.lab.FirstAndReserveTeam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        Team team = new Team("Black Eagles");

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            Person player = new Person(firstName, lastName, age, salary);
            team.addPlayer(player);
        }
    /*    Collections.sort(people, (firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (sComp != 0) {
                return sComp;
            } else {
                return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
            }
        });
        double bonus = Double.parseDouble(scanner.nextLine());
        for (Encapsulation.lab.Encapsulation.exercise.ShoppingSpree.Encapsulation.lab.FirstAndReserveTeam.InterfacesAndAbstraction.exercise.MultipleImplementation.Person Inheritance.exercise.person : people) {
          Inheritance.exercise.person.increaseSalary(bonus);
            System.out.println(Inheritance.exercise.person.toString());
        }*/

        for (Person player : people) {
            team.addPlayer(player);
        }

        System.out.printf("First team have %d players\n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players", team.getReserveTeam().size());

    }
}
