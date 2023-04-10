package Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[rows];
        int[] secondArray = new int[rows];

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {

            int[] inputArray = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            if (rowIndex % 2 == 0) {
                firstArray[rowIndex] = inputArray[0];
                secondArray[rowIndex] = inputArray[1];
            } else {
                firstArray[rowIndex] = inputArray[1];
                secondArray[rowIndex] = inputArray[0];
            }
        }
        Arrays.stream(firstArray).forEach(value -> System.out.print(value + " "));
        System.out.println();
        Arrays.stream(secondArray).forEach(value -> System.out.print(value + " "));

    }
}
