package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        Function<List<Integer>, Integer> function2 = list -> {
            int min = -1;
            OptionalInt optionalMin = list.stream().mapToInt(e -> e).min();
            if (optionalMin.isPresent()) {
                 min = optionalMin.getAsInt();
            }
                return list.lastIndexOf(min);
        };
        int min2ValueIndex = function2.apply(numbers);



        Function<List<Integer>, Integer> function = list -> {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                int current = list.get(i);
                if (current <= min) {
                    min = current;
                    index = i;
                }
            }
            return index;
        };
        int minValueIndex = function.apply(numbers);

        System.out.println(min2ValueIndex);
    }
}
