package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> evenNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        List<Integer> sortedEvenNumber = evenNumbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedEvenNumber.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
