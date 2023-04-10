package JavaBook.ComplexLoops;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        while (!(input >= 1 && input <= 100)) {

            input = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("The number is " + input);
    }
}
