package PFSchool;

import java.util.Scanner;

public class MostCommonNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        int count;
        int max = Integer.MIN_VALUE;
        String mostCommonNumber = "";

        for (int index = 0; index < numbers.length; index++) {

            String currentDigit = numbers[index];
            count = 0;

            for (int i = 0; i < numbers.length; i++) {

                if (currentDigit.equals(numbers[i])) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                mostCommonNumber = currentDigit;
            }
        }
        System.out.printf("The most common element is: %s (%d times)",mostCommonNumber,max);
    }
}
