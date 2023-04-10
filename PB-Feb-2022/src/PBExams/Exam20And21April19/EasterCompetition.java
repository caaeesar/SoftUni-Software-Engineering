package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allEggBreads = Integer.parseInt(scanner.nextLine());
        int currentGrades = 0;
        int maxPoint = Integer.MIN_VALUE;
        String winner = "";

        for (int currentBaker = 1; currentBaker <= allEggBreads; currentBaker++) {

            String name = scanner.nextLine();
            String command = scanner.nextLine();

            while (!command.equals("Stop")) {

                int grade = Integer.parseInt(command);
                currentGrades += grade;
                command = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", name, currentGrades);

            if (currentGrades > maxPoint) {
                maxPoint = currentGrades;
                winner = name;
                System.out.printf("%s is the new number 1!%n", name);
            }
            currentGrades = 0;
        }
        System.out.printf("%s won competition with %d points!", winner, maxPoint);
    }
}
