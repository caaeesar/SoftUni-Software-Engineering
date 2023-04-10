package PBExams.Exam6And7July19;

import java.util.Scanner;

public class PCGameShop {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalGames = Integer.parseInt(scanner.nextLine());
        double count1 = 0.00;
        double count2 = 0.00;
        double count3 = 0.00;
        double count4 = 0.00;

        for (int currentGame = 1; currentGame <= totalGames; currentGame++) {

            String name = scanner.nextLine();

            switch (name) {
                case "Hearthstone":
                    count1++;
                    break;
                case "Fornite":
                    count2++;
                    break;
                case "Overwatch":
                    count3++;
                    break;
                default:
                    count4++;
                    break;
            }
        }

        double percent1 = (count1 / totalGames) * 100;
        double percent2 = (count2 / totalGames) * 100;
        double percent3 = (count3 / totalGames) * 100;
        double percent4 = (count4 / totalGames) * 100;

        System.out.printf("Hearthstone - %.2f%%%n", percent1);
        System.out.printf("Fornite - %.2f%%%n", percent2);
        System.out.printf("Overwatch - %.2f%%%n", percent3);
        System.out.printf("Others - %.2f%%", percent4);
    }
}
