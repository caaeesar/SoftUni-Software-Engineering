package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parse = Integer::parseInt;

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> parse.apply(e))
                .collect(Collectors.toList());

        System.out.printf("Count = %d\n", numbers.size());

        System.out.printf("Sum = %d", numbers.stream().mapToInt(e -> e).sum());
    }
}
