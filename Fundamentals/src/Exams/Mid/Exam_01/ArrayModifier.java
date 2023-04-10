package Exams.Mid.Exam_01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int index1;
        int index2;
        while (!"end".equals(input)) {

            String[] parts = input.split(" ");
            String command = parts[0];
            switch (command) {
                case "swap":
                    index1 = Integer.parseInt(parts[1]);
                    index2 = Integer.parseInt(parts[2]);
                    swapElement(numbers, index1, index2);
                    break;
                case "multiply":
                    index1 = Integer.parseInt(parts[1]);
                    index2 = Integer.parseInt(parts[2]);
                    multiplyElement(numbers, index1, index2);
                    break;
                case "decrease":
                    decreasingAllElement(numbers);
                    break;
            }
            input = scanner.nextLine();
        }
        String arrToString = String.join(", ", Arrays.toString(numbers));
        String arr = arrToString.replaceAll("[]]", "").trim();
        System.out.println(arr.replaceAll("\\[", "").trim());

    }

    private static void decreasingAllElement(int[] numbers) {
        for (int index = 0; index < numbers.length; index++) {
            numbers[index]--;
        }
    }

    private static void multiplyElement(int[] numbers, int index1, int index2) {
        int result = numbers[index1] * numbers[index2];
        numbers[index1] = result;
    }

    private static void swapElement(int[] numbers, int index1, int index2) {
        int firstElement = numbers[index1];
        int secondElement = numbers[index2];
        numbers[index1] = secondElement;
        numbers[index2] = firstElement;
    }
}
