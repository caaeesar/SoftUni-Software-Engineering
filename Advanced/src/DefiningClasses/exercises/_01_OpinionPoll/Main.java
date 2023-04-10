package DefiningClasses.exercises._01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Person> allPeople = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {

            String input = scanner.nextLine();
            String name = input.split("\\s")[0];
            int age = Integer.parseInt(input.split("\\s")[1]);

            Person person = new Person(name, age);
            allPeople.add(person);
        }

        allPeople
                .stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

    }
}
