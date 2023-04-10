package IntroToJava;

import java.util.Scanner;

public class ReadArrayFromConsole {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int index = 0; index < numbers.length; index++) {

            numbers[index] = Integer.parseInt(scanner.nextLine());
        }
    }
}
