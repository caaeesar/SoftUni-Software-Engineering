package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (left, right) -> {
            if (left % 2 == 0 && right % 2 != 0) {
                // първото е четно ; второто е нечетно
                return -1;
            } else if (left % 2 != 0 && right % 2 == 0) {
                // първото е нечетно ; второто е четно
                return 1;
            }
            // двете са четни
            // двете са нечетни
            return left.compareTo(right);
        };
        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
