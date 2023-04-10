package CommonLecture.BitwiseOperations;

import java.util.Arrays;
import java.util.Scanner;

public class OddTimes {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            //XOR of two elements is 0 if both elements are the same, and XOR of a number x with 0 is x 
            result = result ^ numbers[i];
        }

        System.out.println(result);
    }
}
