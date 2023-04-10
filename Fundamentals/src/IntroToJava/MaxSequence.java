package IntroToJava;

import java.util.Scanner;

public class MaxSequence {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];

        readArray(array, numbers);

        int countElements = 0;
        int maxElements = 0;
        int repeatedElement = 0;


        for (int index = 0; index < numbers.length - 1; index++) {

            if (numbers[index] == numbers[index + 1]) {
                countElements++;
            } else {
                countElements = 0;
            }
            if (countElements > maxElements) {
                maxElements = countElements;
                repeatedElement = numbers[index];
            }
        }

        System.out.print("{ ");
        for (int j = 1; j <= maxElements + 1; j++) {

            System.out.printf("%d, ", repeatedElement);
        }
        System.out.print("}");
    }

    static void readArray(String[] array, int[] numbers) {
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
    }
}
