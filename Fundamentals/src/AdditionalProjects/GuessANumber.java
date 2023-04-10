package AdditionalProjects;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {

    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int randomNumber = random.nextInt(1, 101);
        System.out.print("Entry a number: ");
        try {
            int inputNumber = Integer.parseInt(scanner.next());
            while (inputNumber != randomNumber) {
                if (inputNumber < randomNumber) {
                    System.out.println("TOO LOW");
                } else {
                    System.out.println("TOO HIGH");
                }
                System.out.print("Entry a number: ");
                inputNumber = Integer.parseInt(scanner.next());
            }
            System.out.println("You guessed it!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
    }
}
