package CommonLecture.BitwiseOperations;

import java.util.Scanner;

public class GetTheLastBit {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());
        int mask = 1;
        int lastBit = numbers & mask;
        System.out.print(lastBit);
    }
}
