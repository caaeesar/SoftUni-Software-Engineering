package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int givenLength = Integer.parseInt(scanner.nextLine());

        Predicate<String> filterName = w -> w.length() <= givenLength;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(str -> filterName.test(str))
                .forEach(System.out::println);
    }
}
