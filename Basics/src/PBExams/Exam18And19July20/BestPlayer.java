package PBExams.Exam18And19July20;

import java.util.Scanner;

public class BestPlayer {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String bestPlayer = "";
        int maxGoals = Integer.MIN_VALUE;
        boolean isMadeHatTrick = false;

        while (!"END".equals(command)) {

            String playerName = command;
            int currentGoals = Integer.parseInt(scanner.nextLine());

            if (currentGoals > maxGoals) {
                maxGoals = currentGoals;
                bestPlayer = playerName;
            }
            if (currentGoals >= 3) {
                isMadeHatTrick = true;
            }
            if (currentGoals >= 10) {
                break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("%s is the best player!%n", bestPlayer);

        if (isMadeHatTrick) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", maxGoals);
        } else {
            System.out.printf("He has scored %d goals.", maxGoals);
        }
    }
}
