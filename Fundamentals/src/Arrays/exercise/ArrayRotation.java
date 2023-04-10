package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index < rotations; index++) {

            int firstElement = numbers[0];
            for (int position = 0; position < numbers.length - 1; position++) {
                numbers[position] = numbers[position + 1];
            }
            numbers[numbers.length - 1] = firstElement;
        }
        printArray(numbers);
    }

    static void printArray(int[] numbers) {
        for (int currentNumber : numbers) {
            System.out.print(currentNumber + " ");
        }
    }
}
