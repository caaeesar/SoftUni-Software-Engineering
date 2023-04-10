package Methods.moreExercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DataTypes {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String dateType = scanner.nextLine();
        switch (dateType) {
            case "int":
                int x = Integer.parseInt(scanner.nextLine());
                int result1 = operation(x);
                System.out.print(result1);
                break;
            case "real":
                double y = Double.parseDouble(scanner.nextLine());
                double result2 = operation(y);
                System.out.print(new DecimalFormat("0.00").format(result2));
                break;
            case "string":
                String str = scanner.nextLine();
                String output = operation(str);
                System.out.print(output);
                break;
        }
    }

    private static String operation(String str) {
        return "$" + str + "$";
    }

    private static double operation(double y) {
        return y * 1.5;
    }

    private static int operation(int x) {
        return x * 2;
    }
}
