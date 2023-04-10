package PFSchool;

import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       /* for (int index = 0; index < array.length; index++) {

            System.out.print(Integer.parseInt(array[index]) + " ");
            // int numbers = Integer.parseInt(array[index]);
        }*/
        //   System.out.println(Arrays.deepToString(array));

        String[] array = scanner.nextLine().split(" ");

        int[] numbers = new int[array.length];

        for (int index = 0; index < numbers.length; index++) {

            numbers[index] = Integer.parseInt(array[index]);
        }
        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;
        int sum = 0;

        for (int index = 0; index < numbers.length; index++) {

            sum += numbers[index];

            if (numbers[index] > maxNumber) {

                maxNumber = numbers[index];
            }
            if (numbers[index] < minNumber) {
                minNumber = numbers[index];
            }
        }
        System.out.printf("Max = %d%n", maxNumber);
        System.out.printf("Mix = %d%n", minNumber);
        System.out.printf("Sum = %d%n", sum);
        System.out.printf("Average = %.2f", sum * 1.00 / numbers.length);

    }
}

