package Arrays.exercise;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        readArray(arr, numbers);

        for (int i = 0; i < numbers.length; i++) {

            boolean isBigger = true;
            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] <= numbers[j]) {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger) {
                System.out.print(numbers[i] + " ");
            }
        }
    }

    static void readArray(String[] arr, int[] numbers) {
        for (int index = 0; index < arr.length; index++) {
            numbers[index] = Integer.parseInt(arr[index]);
        }
    }
}
