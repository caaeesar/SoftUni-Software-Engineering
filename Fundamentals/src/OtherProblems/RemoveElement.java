package OtherProblems;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];

        readArray(array, numbers);
        System.out.println(Arrays.toString(removeElement(Integer.parseInt(scanner.nextLine()), numbers)));
    }

    static void readArray(String[] array, int[] numbers) {

        for (int index = 0; index < array.length; index++) {
            numbers[index] = Integer.parseInt(array[index]);
        }
    }

    static int[] removeElement(int element, int[] numbers) {
        int removeIndex = findIndex(element, numbers);

        for (int index = removeIndex; index < numbers.length - 1; index++) {

            numbers[index] = numbers[index + 1];
        }
        numbers[numbers.length - 1] = 0;
        return numbers;
    }

    static int findIndex(int element, int[] numbers) {

        for (int index = 0; index < numbers.length; index++) {

            if (numbers[index] == element) {
                return index;
            }
        }
        return -1;
    }
}
