package DataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class RefactoringPrimeChecker {
    public static void main(String[] arguments) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        for (int currentNumber = 2; currentNumber <= n; currentNumber++) {
            boolean isPrime = true;
            for (int division = 2; division < currentNumber; division++) {
                if (currentNumber % division == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", currentNumber, isPrime);
        }
    }
}
