package ForLoop.lab;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // * алгоритъм за взимане на най-малкото и най-голямото число:

        int n = Integer.parseInt(scanner.nextLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        System.out.println("Max number: " + max);
        System.out.println("Min number: " + min);
    }
}
