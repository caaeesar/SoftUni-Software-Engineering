package Basic.moreExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Double[] numbers = new Double[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = Double.parseDouble(scanner.nextLine());
        }
        Arrays.sort(numbers, Collections.reverseOrder());
        for (Double currentNumber : numbers) {
            System.out.printf("%.0f%n",currentNumber);
        }
    }
}
