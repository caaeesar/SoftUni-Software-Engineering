package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] ranges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int lowerBound = ranges[0];
        int upperBound = ranges[1];

        String condition = scanner.nextLine();

        Predicate<Integer> filter = condition.equals("even") ?
                num -> num % 2 == 0 :
                num -> num % 2 != 0;

        Consumer<Integer> print = number -> System.out.print(number + " ");

        IntStream.rangeClosed(lowerBound,upperBound)
                .filter(number -> filter.test(number))
                .forEach(number -> print.accept(number));

    }
}
