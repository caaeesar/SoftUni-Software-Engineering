package ConditionalStatementsAdvanced.moreExercise;

import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i > 0; i++) {
            double currentNum = Double.parseDouble(scanner.nextLine());
            if (currentNum >= 0) {
                double result = currentNum * 2;
                System.out.printf("Result: %.2f%n",result);
            } else {
                System.out.println("Negative number!");
                break;
            }

        }
    }
}
