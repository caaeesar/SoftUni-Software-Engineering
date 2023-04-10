package Arrays.lab;

import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * int[] arr1 = Arrays.stream(scanner.nextLine().split(" "))
         *                 .mapToInt(Integer::parseInt)
         *                 .toArray();
         * int[] arr2 = Arrays.stream(scanner.nextLine().split(" "))
         *                 .mapToInt(Integer::parseInt)
         *                 .toArray();
         *
         *         int sum = 0;
         *         for (int index = 0; index < arr1.length; index++) {
         *
         *             if (arr1[index] != arr2[index]) {
         *                 System.out.printf("Arrays are not identical. Found difference at %d index.", index);
         *                 return;
         *             } else {
         *                 sum += arr1[index];
         *             }
         *         }
         *         System.out.printf("Arrays are identical. Sum: %d", sum);
         */

        String[] array1 = scanner.nextLine().split(" ");
        int[] numbers1 = readArray(array1);
        String[] array2 = scanner.nextLine().split(" ");
        int[] numbers2 = readArray(array2);
        boolean isEqual = compare(numbers1, numbers2);
        if (isEqual) {
            int sum = 0;
            for (int index = 0; index < numbers1.length; index++) {
                sum += numbers1[index];
            }
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            int differentIndex = 0;
            for (int index = 0; index < numbers1.length; index++) {
                if (numbers1[index] != numbers2[index]) {
                    differentIndex = index;
                    break;
                }
            }
            System.out.printf("Arrays are not identical. Found difference at %d index.", differentIndex);
        }

    }

    static int[] readArray(String[] array) {
        int[] numbers = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
        return numbers;
    }

    static boolean compare(int[] number1, int[] number2) {
        boolean isEqual = true;
        for (int index = 0; index < number1.length; index++) {
            if (number1[index] != number2[index]) {
                isEqual = false;
            }
        }
        return isEqual;
    }
}
