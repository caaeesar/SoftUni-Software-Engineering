package Arrays.exercise;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *  int[] sequence = Arrays.stream(scanner.nextLine().split(" "))
         *                 .mapToInt(Integer::parseInt)
         *                 .toArray();
         */
        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];
        readArray(array, numbers);
        int magicNum = Integer.parseInt(scanner.nextLine());

        for (int position = 0; position < numbers.length; position++) {

            for (int index = position + 1; index < numbers.length; index++) {

                int currentSum = numbers[position] + numbers[index];
                if (currentSum == magicNum) {
                    System.out.printf("%d %d%n", numbers[position], numbers[index]);
                }
            }
        }
    }

    static void readArray(String[] array, int[] numbers) {
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
    }
}
