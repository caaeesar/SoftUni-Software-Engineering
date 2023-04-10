package JavaBook.Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        DecimalFormat format = new DecimalFormat("#.##########");
        double number = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());
        double result = calculate(number, power);
        System.out.print(format.format(result));

    }

    static double calculate(double n, double end) {

        double copyN = n;
        for (int i = 1; i < end; i++) {
            n *= copyN;
        }
        return n;
    }
}
