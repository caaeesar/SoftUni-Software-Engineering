package PFSchool;

import java.util.Arrays;
import java.util.Scanner;

public class InsertElement {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        int n = Integer.parseInt(scanner.nextLine());

        numbers[numbers.length - 1] = n;

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
