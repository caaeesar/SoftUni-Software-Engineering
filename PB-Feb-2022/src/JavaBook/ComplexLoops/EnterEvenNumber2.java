package JavaBook.ComplexLoops;

import java.util.Scanner;

public class EnterEvenNumber2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = 0;

        while (true) {
            try {
               number = Integer.parseInt(scanner.nextLine());
                if (number % 2 == 0) {
                    System.out.print("The number is even " + number);
                    break;
                } else {
                    System.out.print("The number is not even\n");
                }
            } catch (Exception ex) {
                System.out.println("Invalid number");
            }
        }
    }
}
