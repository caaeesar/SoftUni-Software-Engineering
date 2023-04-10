package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numberToDivide = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> isDivisible = number -> {
            for (int i = 0; i < numberToDivide.length; i++) {
                if (number % numberToDivide[i] != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1,n)
                .boxed()
                .filter(e -> isDivisible.test(e)).
                forEach(e -> System.out.print(e + " "));
    }
}
