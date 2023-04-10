package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

       Function<int[], int[]> addFunction = array -> {
            for (int i = 0; i < array.length; i++) {
                array[i]++;
            }
            return array;
        };

        Function<int[], int[]> multiplyFunction = array -> {
            for (int i = 0; i < array.length; i++) {
                array[i] *= 2;
            }
            return array;
        };

        Function<int[], int[]> subtractFunction = array -> {
            for (int i = 0; i < array.length; i++) {
                array[i] -= 1;
            }
            return array;
        };

        //UnaryOperator<int[]> addFunction = arr -> Arrays.stream(arr).map(e -> e + 1).toArray();

        Consumer<int[]> printElements = elements ->
                System.out.println(Arrays.toString(elements)
                        .replaceAll("[\\[\\],]", ""));

        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            switch (command) {
                case "add":
                    addFunction.apply(numbers);
                    break;
                case "multiply":
                    multiplyFunction.apply(numbers);
                    break;
                case "subtract":
                    subtractFunction.apply(numbers);
                    break;
                case "print":
                    printElements.accept(numbers);
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
