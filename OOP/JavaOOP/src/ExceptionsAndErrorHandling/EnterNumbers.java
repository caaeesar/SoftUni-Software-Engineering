package ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    private static Scanner scanner;

    public static void main(String[] arguments) {

        scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        int start = 1;
        int end = 100;

        while (numbers.size() < 10) {
            try {
                start = readNumber(start, end);
                numbers.add(start);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }

    private static int readNumber(int lowerBound, int upperBound) {
        String input = scanner.nextLine();
        int number = 0;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Number!");
        }
        if (number <= lowerBound || number >= upperBound) {
            String message = String.format("Your number is not in range %d - %d!",
                    lowerBound, upperBound);
            throw new NumberFormatException(message);
        }
        return number;
    }
}
