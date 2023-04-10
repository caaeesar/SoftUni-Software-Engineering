package PBExams.Exam25And26Jun22;

import java.util.Scanner;

public class GiftsFromSanta {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int s = Integer.parseInt(scanner.nextLine());

        for (int currentAddress = m; currentAddress >= n; currentAddress--) {

            boolean condition1 = currentAddress % 2 == 0;
            boolean condition2 = currentAddress % 3 == 0;

            if (condition1 && condition2) {

                if (currentAddress == s) {
                    break;
                } else {
                System.out.printf("%d ", currentAddress);

                }
            }

        }

    }
}
