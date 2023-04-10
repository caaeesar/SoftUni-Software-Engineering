package ForLoop.exercise;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String actor = scanner.nextLine();
        double totalPoint = Double.parseDouble(scanner.nextLine());
        int judges = Integer.parseInt(scanner.nextLine());
        boolean isNominated = false;

        for (int currentJudge = 1; currentJudge <= judges; currentJudge++) {

            String judgeName = scanner.nextLine();
            double currentPoint = Double.parseDouble(scanner.nextLine());
            int length = judgeName.length();
            totalPoint += (length * currentPoint) / 2;

            if (totalPoint > 1250.5) {
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", actor, totalPoint);
                isNominated = true;
                break;
            }
        }
        if (!isNominated) {
            System.out.printf("Sorry, %s you need %.1f more!", actor, 1250.5 - totalPoint);
        }
    }
}

