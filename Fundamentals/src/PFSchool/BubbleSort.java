package PFSchool;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];

        for (int index = 0; index < array.length; index++) {

            numbers[index] = Integer.parseInt(array[index]);
        }

        for (int index = 0; index < numbers.length - 1; index++) {

            if (numbers[index] > numbers[index + 1]) {

                int swapVar = numbers[index];
                numbers[index] = numbers[index + 1];
                numbers[index + 1] = swapVar;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
