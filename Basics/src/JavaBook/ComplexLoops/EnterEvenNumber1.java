package JavaBook.ComplexLoops;

import java.util.Scanner;

public class EnterEvenNumber1 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        while (true) {

            if (number % 2 != 0) {
                number = Integer.parseInt(scanner.nextLine());
            } else {
                System.out.println(number);
                break;
            }
        }
    }
}
