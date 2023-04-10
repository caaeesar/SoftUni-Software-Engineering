package ForLoop.moreExercise;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        // с Double.MIN/MAX_VALUE; не работи ??

        int input = Integer.parseInt(scanner.nextLine());
        double evenSum = 0.00;
        double evenMax = -1000000000.0;
        double evenMin = 1000000000.0;

        double oddSum = 0.00;
        double oddMax = -1000000000.0;
        double oddMin = 1000000000.0;

        for (int i = 1; i <= input; i++) {
            double currentNumber = Double.parseDouble(scanner.nextLine());

            if (i % 2 == 0) { // четни
                evenSum += currentNumber;

                if (currentNumber > evenMax) { // макс
                    evenMax = currentNumber;
                }
                if (currentNumber < evenMin) { // мин
                    evenMin = currentNumber;

                }
            } else { // нечетни
                oddSum += currentNumber;

                if (currentNumber > oddMax) { // макс
                    oddMax = currentNumber;
                }
                if (currentNumber < oddMin) { // мин
                    oddMin = currentNumber;
                }
            }
        }
        if (input > 1) {
            System.out.printf("OddSum=%.2f,\n", oddSum);
            System.out.printf("OddMin=%.2f,\n", oddMin);
            System.out.printf("OddMax=%.2f,\n", oddMax);
            System.out.printf("EvenSum=%.2f,\n", evenSum);
            System.out.printf("EvenMin=%.2f,\n", evenMin);
            System.out.printf("EvenMax=%.2f", evenMax);
        }
        if (input == 0) {
            System.out.printf("OddSum=%.2f,\n", oddSum);
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
            System.out.printf("EvenSum=%.2f,\n", evenSum);
            System.out.println("EvenMin=No,");
            System.out.print("EvenMax=No");
        }
        if (input == 1) {
            System.out.printf("OddSum=%.2f,\n", oddSum);
            System.out.printf("OddMin=%.2f,\n", oddMin);
            System.out.printf("OddMax=%.2f,\n", oddMax);
            System.out.printf("EvenSum=%.2f,\n", evenSum);
            System.out.println("EvenMin=No,");
            System.out.print("EvenMax=No");
        }
    }
}
