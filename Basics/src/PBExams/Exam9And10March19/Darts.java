package PBExams.Exam9And10March19;

import java.util.Scanner;

public class Darts {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String currentField = scanner.nextLine();
        int startPoint = 301;
        int fails = 0;
        int success = 0;

        while (!currentField.equals("Retire")) {

            int currentPoint = Integer.parseInt(scanner.nextLine());

            switch (currentField) {

                case "Single":
                    break;
                case "Double":
                    currentPoint *= 2;
                    break;
                case "Triple":
                    currentPoint *= 3;
                    break;
            }
            if (currentPoint > startPoint) {
                currentField = scanner.nextLine();
                fails++;
                continue;
            } else {
                startPoint -= currentPoint;
                success++;
            }
            if (startPoint <= 0) {
                System.out.printf("%s won the leg with %d shots.", name, success);
                break;
            }
            currentField = scanner.nextLine();
        }
        if (currentField.equals("Retire")) {
            System.out.printf("%s retired after %d unsuccessful shots.", name, fails);
        }
    }
}
