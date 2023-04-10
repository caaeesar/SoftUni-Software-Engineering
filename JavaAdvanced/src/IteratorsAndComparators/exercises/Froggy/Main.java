package IteratorsAndComparators.exercises.Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String end = scanner.nextLine();

        Lake lake = new Lake(elements);

        List<String> output = new ArrayList<>();
        for (int value : lake) {
            output.add(String.valueOf(value));
        }
        System.out.print(String.join(", ",output));
    }
}
