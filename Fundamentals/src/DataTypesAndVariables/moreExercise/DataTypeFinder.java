package DataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

       /* String input = scanner.nextLine();
        int integerType = 0;
        double doubleType = 0.00;

        while (!"END".equals(input)) {

            boolean isInt = true;
            try {
                integerType = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                isInt = false;
            }

            boolean isDouble = true;
            try {
                doubleType = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                isDouble = false;
            }

            if (isInt) {
                System.out.printf("%s is integer type%n", integerType);
            } else if (isDouble) {
                System.out.printf("%s is floating point type%n", doubleType);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }
            input = scanner.nextLine();
        }*/

        String input = scanner.nextLine();
        while (!"END".equals(input)) {

            Scanner readDate = new Scanner(input);

            if (readDate.hasNextInt()) {
                System.out.printf("%s is integer type%n", input);
            } else if (readDate.hasNextDouble()) {
                System.out.printf("%s is floating type%n", input);
            } else if (readDate.hasNextBoolean()) {
                System.out.printf("%s is boolean type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
