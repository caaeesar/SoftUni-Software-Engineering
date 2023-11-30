package ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] range = Arrays.stream(scanner.nextLine().split("\\s+")).toArray(String[]::new);

        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        System.out.printf("Range: [%d...%d]\n", start, end);

        while (true) {

            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                if (number >= start && number <= end) {
                    System.out.println("Valid number: " + number);
                    break;
                } else {
                    System.out.println("Invalid number: " + number);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid number: " + input);
            }
        }
    }
}


