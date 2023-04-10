package Arrays.lab;

import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];
        readArray(array,numbers);
       int sum =  sumPrimeNumbers(numbers);
       System.out.print(sum);

        /*
         * int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
         *                 .mapToInt(Integer::parseInt)
         *                 .filter(e -> e % 2 == 0)
         *                 .toArray();
         *
         *         int sum = 0;
         *         for (int index = 0; index < numbers.length; index++) {
         *             sum += numbers[index];
         *         }
         *         System.out.print(sum);
         */
    }

    static void readArray(String[] arr, int[] numbers) {
        for (int index = 0; index < arr.length; index++) {
            numbers[index] = Integer.parseInt(arr[index]);
        }
    }
    static int sumPrimeNumbers(int[] numbers) {
        int sum = 0;

        for (int index = 0; index < numbers.length; index++) {
            int currentNumber = numbers[index];

                if (currentNumber % 2 == 0) {
                    sum += currentNumber;
                }
            }
        return sum;
    }
}
