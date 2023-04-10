package PBExams.PreExam18And19June22;

import java.util.Scanner;

public class Everest {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int countDays = 1;
        int allMeters = 5364;
        int goals = 8848;
        boolean isReached = false;

        while (!command.equals("END")) {

            String restOrNot = command;
            int currentMeters = Integer.parseInt(scanner.nextLine());

            if ("Yes".equals(restOrNot)) {
                countDays++;
                if ((countDays > 5)) {
                    break;
                }
                allMeters += currentMeters;
            } else if ("No".equals(restOrNot)) {
                allMeters += currentMeters;
            }
            if (allMeters >= goals) {
                isReached = true;
                break;
            }
            command = scanner.nextLine();
        }

        if (isReached) {
            System.out.printf("Goal reached for %d days!", countDays);
        } else if ("END".equals(command)) {
            System.out.println("Failed!");
            System.out.printf("%d", allMeters);
        } else {
            System.out.println("Failed!");
            System.out.printf("%d", allMeters);
        }
    }
}
