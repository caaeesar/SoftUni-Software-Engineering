package IntroToJava;

import java.util.Scanner;

public class SumEqualsElements {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //todo zad.9
        String[] array = scanner.nextLine().split("");
        int sum = Integer.parseInt(scanner.nextLine());
        int[] numbers = readArray(array);
        checkElement(sum, numbers);

    }

    static int[] readArray(String[] array) {
        int[] numbers = new int[array.length];
        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
        return numbers;
    }

    static void checkElement(int sum, int[] numbers) {
        int currentSum = 0;
        while (currentSum != sum) {
            for (int index = 0; index < numbers.length - 1; index++) {
                currentSum += (numbers[index] + numbers[index + 1]);
                if (currentSum == sum) {
                    return;
                }
            }
        }
    }
}
