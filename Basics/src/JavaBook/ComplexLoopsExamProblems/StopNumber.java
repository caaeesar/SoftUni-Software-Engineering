package JavaBook.ComplexLoopsExamProblems;

import java.util.Scanner;

public class StopNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int s = Integer.parseInt(scanner.nextLine());


        for (int currentNumber = m; currentNumber >= n; currentNumber--) {

            if (currentNumber % 2 == 0 && currentNumber % 3 == 0) {

                int validNum = currentNumber;

                if (validNum != s) {

                    System.out.printf("%d ", validNum);
                } else {
                    break;
                }

            }
        }
    }
}
