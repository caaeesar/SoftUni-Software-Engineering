package PBExams.Exam6And7July19;

import java.util.Scanner;

public class NameGame {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String winnerName = "";

        int maxPoint = Integer.MIN_VALUE;

        while (!name.equals("Stop")) {

            int point = 0;

            for (char position = 0; position < name.length(); position++) {

                char letter = name.charAt(position);
                int currentNumber = Integer.parseInt(scanner.nextLine());

                if (currentNumber == letter) {
                    point += 10;
                } else {
                    point += 2;
                }
            }
            if (point >= maxPoint) {
                maxPoint = point;
                winnerName = name;
            }
            name = scanner.nextLine();
        }
            System.out.printf("The winner is %s with %d points!", winnerName, maxPoint);

    }
}
