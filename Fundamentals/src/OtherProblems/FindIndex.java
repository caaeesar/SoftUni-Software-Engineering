package OtherProblems;

import java.util.Scanner;

public class FindIndex {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];
        readArray(array, numbers);
        System.out.println(findIndex(numbers, Integer.parseInt(scanner.nextLine())));
    }

    static void readArray(String[] array, int[] numbers) {

        for (int index = 0; index < array.length; index++) {

            numbers[index] = Integer.parseInt(array[index]);
        }
    }

    static int findIndex(int[] numbers, int element) {

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
