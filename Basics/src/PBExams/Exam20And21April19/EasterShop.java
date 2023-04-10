package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterShop {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEgg = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int soldEggs = 0;

        while (!command.equals("Close")) {

            int eggs = Integer.parseInt(scanner.nextLine());

            if ("Buy".equals(command)) {

                if (eggs > numberOfEgg) {
                    System.out.println("Not enough eggs in store!");
                    System.out.printf("You can buy only %d.", numberOfEgg);
                    break;
                } else {
                    numberOfEgg -= eggs;
                    soldEggs += eggs;
                }
            } else if ("Fill".equals(command)) {
                numberOfEgg += eggs;
            }
            command = scanner.nextLine();
        }
        if ("Close".equals(command)) {
            System.out.println("Store is closed!");
            System.out.printf("%d eggs sold.", soldEggs);
        }
    }
}
