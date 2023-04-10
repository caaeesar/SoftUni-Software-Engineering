package PBExams.Exam28And29March20;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalDays = Integer.parseInt(scanner.nextLine());
        int win = 0;
        int lose = 0;
        double raisedMoney = 0.00;
        int allWins = 0;
        int allLose = 0;
        double totalMoney = 0.00;

        for (int currentDay = 1; currentDay <= totalDays; currentDay++) {

            String command = scanner.nextLine();
            while (!"Finish".equals(command)) {

                // String game = command;
                String result = scanner.nextLine();

                switch (result) {

                    case "win":
                        win++;
                        raisedMoney += 20;
                        break;
                    case "lose":
                        lose++;
                        break;
                }
                command = scanner.nextLine();
            }
            if (win > lose) {
                raisedMoney += (raisedMoney * 0.1);
                allWins++;
            } else {
                allLose++;
            }
            win = 0;
            lose = 0;
            totalMoney += raisedMoney;
            raisedMoney = 0;
        }
        if (allWins > allLose) {
            totalMoney += (totalMoney * 0.2);
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoney);
        }
    }
}
