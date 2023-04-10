package IntroToJava;

import java.util.Scanner;

public class FirstBigElement {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("");
        int[] numbers = readArray(array);
        int position = getPosition(numbers);
        System.out.printf("Element of position %d is bigger than its adjacent element", position);
    }

    static int[] readArray(String[] array) {
        int[] numbers = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
        return numbers;
    }

    static int getPosition(int[] numbers) {
        for (int index = 0; index < numbers.length; index++) {

            if (index == 0) {
                boolean condition = numbers[index] > numbers[index + 1];
                if (condition) {
                    return index;
                }
            } else if (index == numbers.length - 1) {
                boolean condition = numbers[index] > numbers[index - 1];
                if (condition) {
                    return index;
                }
            } else {
                boolean condition = numbers[index] > numbers[index - 1] && numbers[index] > numbers[index + 1];
                if (condition) {
                    return index;
                }
            }
        }
        return -1;
    }
}

