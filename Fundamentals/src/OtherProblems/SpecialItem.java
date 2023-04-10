package OtherProblems;

import java.util.Scanner;

public class SpecialItem {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] numbers = new int[arr.length];
        int specialItem = Integer.parseInt(scanner.nextLine());
        readArray(arr, numbers);
        System.out.println( checkItems(specialItem, numbers));

    }

    static void readArray(String[] array, int[] numbers) {

        for (int index = 0; index < array.length; index++) {

            numbers[index] = Integer.parseInt(array[index]);
        }
    }

    static boolean checkItems(int item, int[] numbers) {

        for (int currentNum : numbers) {

            if (currentNum == item) {
                return true;
            }
        }
        return false;
    }
}
