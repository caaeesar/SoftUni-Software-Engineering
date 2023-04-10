package Exams.MidRetake.Exam_02;

import java.util.Scanner;

public class CounterStrike {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        int wonBattles = 0;
        int countBattle = 0;

        String input = scanner.nextLine();
        while (!"End of battle".equals(input)) {
            int distance = Integer.parseInt(input);
            if (initialEnergy >= distance) {
                countBattle++;
                wonBattles++;
                initialEnergy -= distance;
                if (countBattle == 3) {
                    initialEnergy += wonBattles;
                    countBattle = 0;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, initialEnergy);
                break;
            }
            input = scanner.nextLine();
        }
        if (input.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, initialEnergy);
        }
    }
}
