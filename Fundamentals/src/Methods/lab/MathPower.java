package Methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        double result = summing(number, power);
        System.out.print(new DecimalFormat("0.####").format(result));
    }

    static double summing(double number, int count) {
        double sum = number;
        for (int i = 0; i < count - 1; i++) {
            sum *= number;
        }
        return sum;
    }
}
