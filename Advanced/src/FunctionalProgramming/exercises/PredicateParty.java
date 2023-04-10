package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        BiFunction<List<String>, String, String[]> getPeopleWith =
                (list, criteria) -> list.stream()
                        .filter(p -> p.startsWith(criteria))
                        .toArray(String[]::new);

        BiFunction<List<String>, String, String[]> getPeopleEnd =
                (list, criteria) -> list.stream()
                        .filter(p -> p.endsWith(criteria))
                        .toArray(String[]::new);

        BiFunction<List<String>, Integer, String[]> getPeopleValidLength =
                (list, givenLength) -> list.stream()
                        .filter(p -> p.length() == givenLength)
                        .toArray(String[]::new);

        String input = scanner.nextLine();
        while (!"Party!".equals(input)) {

            String command = input.split("\\s+")[0];
            String condition = input.split("\\s+")[1];
            String criteria = input.split("\\s+")[2];

            switch (command) {
                case "Remove":
                    if (condition.equals("StartsWith")) {
                        people.removeIf(p -> p.startsWith(criteria));
                    } else if (condition.equals("EndsWith")) {
                        people.removeIf(p -> p.endsWith(criteria));
                    } else {
                        int givenLength = Integer.parseInt(criteria);
                        people.removeIf(p -> p.length() == givenLength);
                    }
                    break;
                case "Double":
                    if (condition.equals("StartsWith")) {
                        String[] validPeople = getPeopleWith.apply(people, criteria);
                        people.addAll(List.of(validPeople));
                    } else if (condition.equals("EndsWith")) {
                        String[] validPeople = getPeopleEnd.apply(people, criteria);
                        people.addAll(List.of(validPeople));
                    } else {
                        int givenLength = Integer.parseInt(criteria);
                        String[] validPeople = getPeopleValidLength.apply(people, givenLength);
                        people.addAll(List.of(validPeople));
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        if (people.isEmpty()) {
            System.out.print("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            String joinedNames = String.join(", ", people);
            System.out.printf("%s are going to the party!",joinedNames);
        }
    }
}
