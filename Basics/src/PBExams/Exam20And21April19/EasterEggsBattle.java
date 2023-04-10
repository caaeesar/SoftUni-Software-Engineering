package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterEggsBattle {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int eggsFirstPlayer = Integer.parseInt(scanner.nextLine());
        int eggsSecondPlayer = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("End")) {

            switch (command) {

                case "one":
                    eggsSecondPlayer--;
                    break;
                case "two":
                    eggsFirstPlayer--;
                    break;
            }

            if (eggsFirstPlayer <= 0) {
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.", eggsSecondPlayer);
                break;
            } else if (eggsSecondPlayer <= 0) {
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.", eggsFirstPlayer);
                break;
            }
            command = scanner.nextLine();
        }

        if (command.equals("End")) {
            System.out.printf("Player one has %d eggs left.%n", eggsFirstPlayer);
            System.out.printf("Player two has %d eggs left.", eggsSecondPlayer);
        }
    }
}
