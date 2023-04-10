package NestedLoops.moreExercise;

import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allMen = Integer.parseInt(scanner.nextLine());
        int allWomen = Integer.parseInt(scanner.nextLine());
        int freeTables = Integer.parseInt(scanner.nextLine());
        int freeSeats = freeTables * 2;
        boolean isHave = true;

        for (int man = 1; man <= allMen; man++) {

            for (int woman = 1; woman <= allWomen; woman++) {

                if (freeSeats <= 0) {
                    isHave = false;
                    break;
                }
                freeSeats -= 2;

                System.out.printf("(%d <-> %d) ", man, woman);
            }
            if (!isHave) {
                break;
            }
        }

    }
}
