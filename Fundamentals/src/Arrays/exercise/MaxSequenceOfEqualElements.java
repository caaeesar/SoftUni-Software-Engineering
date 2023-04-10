package Arrays.exercise;

import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = readArray(array);
        int maxSeq = 0;
        int currentSeq = 0;
        int repeatedElement = -1;

        for (int index = 0; index < numbers.length - 1; index++) {

            if (numbers[index] == numbers[index + 1]){
                currentSeq++;
            } else {
                currentSeq = 0;
            }
            if (currentSeq > maxSeq) {
                maxSeq = currentSeq;
                repeatedElement = numbers[index];
            }
        }

        // add 1 for the first same element
        for (int i = 1; i <= maxSeq + 1; i++) {
            System.out.print(repeatedElement + " ");
        }
    }

    static int[] readArray(String[] array) {
        int[] numbers = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
        return numbers;
    }
}
