package PBExams.Exam9And10March19;

import java.util.Scanner;

public class GameNumberWars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        int firstPoint = 0;
        int secondPoint = 0;

        String command = scanner.nextLine();

        while (!command.equals("End of game")) {

            int firstCard = Integer.parseInt(command);
            int secondCard = Integer.parseInt(scanner.nextLine());

            if (firstCard > secondCard) {

                firstPoint += (firstCard - secondCard);

            } else if (secondCard > firstCard) {

                secondPoint += (secondCard - firstCard);

            } else {
                int player1NextCard = Integer.parseInt(scanner.nextLine());
                int player2NextCard = Integer.parseInt(scanner.nextLine());

                if (player1NextCard > player2NextCard) {

                    System.out.println("Number wars!");
                    System.out.printf("%s is winner with %d points", firstName, firstPoint);

                } else if (player2NextCard > player1NextCard) {

                    System.out.println("Number wars!");
                    System.out.printf("%s is winner with %d points", secondName, secondPoint);
                }
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("End of game")) {
            System.out.printf("%s has %d points%n", firstName, firstPoint);
            System.out.printf("%s has %d points", secondName, secondPoint);
        }
    }
}
