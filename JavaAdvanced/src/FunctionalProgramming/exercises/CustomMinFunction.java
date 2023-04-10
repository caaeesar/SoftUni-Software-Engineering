package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

       /* Function<int[],Integer> getMinValue = elements -> Collections.min(Arrays.stream(elements).boxed().collect(Collectors.toList()));
        System.out.println(getMinValue.apply(numbers));*/

        Function<int[], Integer> function = arr -> {
            int min = Integer.MAX_VALUE;
            for (int current : arr) {
                if (current < min) {
                    min = current;
                }
            }
            return min;
        };
        int min = function.apply(numbers);
        System.out.println(min);
    }
}
