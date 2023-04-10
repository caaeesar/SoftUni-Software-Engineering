package Arrays.lab;

import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = readArray(array);

        while (numbers.length > 1) {

            // дължината на новия масив се намаля винаги с 1;
            int[] condensed = new int[numbers.length - 1];

            for (int i = 0; i < condensed.length; i++) {

                condensed[i] = numbers[i] + numbers[i + 1];
            }
            numbers = condensed;
        }
        System.out.print(numbers[0]);
    }

    static int[] readArray(String[] array) {
        int[] numbers = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
        return numbers;
    }
}
