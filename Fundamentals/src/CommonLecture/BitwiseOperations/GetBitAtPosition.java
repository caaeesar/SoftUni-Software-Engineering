package CommonLecture.BitwiseOperations;

import java.util.Scanner;

public class GetBitAtPosition {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int mask = number >> position;
        int bit = mask & 1;

        System.out.printf("Number: %d, the bit at %d position is %d", number, position, bit);
    }
}
