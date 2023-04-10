package Arrays.lab;

import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
         *                 .mapToInt(Integer::parseInt)
         *                 .toArray();
         *
         *         int evenSum = Arrays.stream(numbers)
         *                 .filter(e -> e % 2 == 0)
         *                 .sum();
         *         int oddSum = Arrays.stream(numbers)
         *                 .filter(e -> e % 2 != 0)
         *                 .sum();
         *
         *         System.out.print(evenSum - oddSum);
         */


        String[] array = scanner.nextLine().split(" ");
        int[] numbers = readArray(array);
        int evenSum = getEvenSum(numbers);
        int oddSum = getOddSum(numbers);
        int diff = getDiff(evenSum, oddSum);
        System.out.print(diff);
    }

    static int[] readArray(String[] arr) {
        int[] numbers = new int[arr.length];

        for (int index = 0; index < arr.length; index++) {
            numbers[index] = Integer.parseInt(arr[index]);
        }
        return numbers;
    }

    static int getEvenSum(int[] numbers) {
        int evenSum = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] % 2 == 0) {
                evenSum += numbers[index];
            }
        }
        return evenSum;
    }

    static int getOddSum(int[] numbers) {
        int oddSum = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] % 2 != 0) {
                oddSum += numbers[index];
            }
        }
        return oddSum;
    }

    static int getDiff(int evenSum, int oddSum) {
        return evenSum - oddSum;
    }
}
