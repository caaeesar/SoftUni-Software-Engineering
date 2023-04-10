package Arrays.exercise;

import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = readArray(array);
        String input = scanner.next();

        while (!"end".equals(input)) {

            String command = input;
            switch (command) {
                case "swap":
                    int swapIndex1 = scanner.nextInt();
                    int swapIndex2 = scanner.nextInt();
                    swappingElements(numbers, swapIndex1, swapIndex2);
                    break;
                case "multiply":
                    int multiplyIndex1 = scanner.nextInt();
                    int multiplyIndex2 = scanner.nextInt();
                    multiplyingElements(numbers, multiplyIndex1, multiplyIndex2);
                    break;
                case "decrease":
                    decreasing(numbers);
                    break;
            }
            input = scanner.next();
        }
        printArray(numbers);
    }

    static int[] readArray(String[] arr) {
        int[] numbers = new int[arr.length];
        for (int index = 0; index < arr.length; index++) {
            numbers[index] = Integer.parseInt(arr[index]);
        }
        return numbers;
    }

    static void swappingElements(int[] numbers, int index1, int index2) {
        int swapVar = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = swapVar;
    }

    static void multiplyingElements(int[] numbers, int index1, int index2) {
        int result = numbers[index1] * numbers[index2];
        numbers[index1] = result;
    }

    static void decreasing(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] -= 1;
        }
    }

    static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {
                System.out.printf("%d", numbers[i]);
            } else {
                System.out.printf("%d, ", numbers[i]);
            }
        }
    }
}
