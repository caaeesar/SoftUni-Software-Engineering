package SetsAndMaps.exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] lengths = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while (lengths[0]-- > 0) {
            int currentValue = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentValue);
        }

        while (lengths[1]-- > 0) {
            int currentValue = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentValue);
        }

        firstSet.retainAll(secondSet);
        System.out.print(firstSet.toString().replaceAll("[\\[\\],]", ""));
    }
}
