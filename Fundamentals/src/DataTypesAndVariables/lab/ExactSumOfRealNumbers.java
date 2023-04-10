package DataTypesAndVariables.lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < n; i++) {

            BigDecimal currentNumber = scanner.nextBigDecimal();
            sum = sum.add(currentNumber);
        }
        System.out.print(sum);
    }
}
