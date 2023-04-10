package JavaBook;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double value = Double.parseDouble(scan.nextLine());
        String input = scan.nextLine().toLowerCase();
        String output = scan.nextLine().toLowerCase();

        double mm = 1000;
        double cm = 100;
        double mi = 0.000621371192;
        double in = 39.3700787;
        double km = 0.001;
        double ft = 3.2808399;
        double yd = 1.0936133;
        double m = 1.0;

        double result = 0.00;

        switch (input) {
            case "m":
               result = value / m;
                break;
            case "mm":
                result = value / mm;
                break;
            case "cm":
                result = value / cm;
                break;
            case "mi":
                result = value / mi;
                break;
            case "in":
                result = value / in;
                break;
            case "km":
                result = value / km;
                break;
            case "ft":
                result = value / ft;
                break;
            case "yd":
                result = value / yd;
                break;

        }
        switch (output) {
            case "m":
                result *= m;
                break;
            case "mm":
                result *= mm;
                break;
            case "cm":
                result *= cm;
                break;
            case "mi":
                result *= mi;
                break;
            case "in":
                result *= in;
                break;
            case "km":
                result *= km;
                break;
            case "ft":
                result *= ft;
                break;
            case "yd":
                result *= yd;
                break;
        }

        System.out.printf("%f",result);

    }
}
