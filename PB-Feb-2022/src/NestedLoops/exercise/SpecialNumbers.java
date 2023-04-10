package NestedLoops.exercise;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        // преминаваме през всяко едно число в този диапазон:
        for (int currentNumber = 1111; currentNumber <= 9999; currentNumber++) {

            int copyNumber = currentNumber;
            boolean isNotSpecial = false;

            while (copyNumber != 0) { // for (int digit = 4; digit >= 1; digit--)

                int divider = copyNumber % 10;

                if (divider == 0) { // на нула не може да се дели
                    isNotSpecial = true;
                    break;
                }
                if (input % divider != 0) {
                    isNotSpecial = true;
                    break;
                }
                copyNumber = copyNumber / 10;
            }
            if (!isNotSpecial) {
                System.out.printf("%d ", currentNumber);
            }
        }

      /*  for (int currentNumber = 1111; currentNumber <= 9999; currentNumber++) {

            String numberAsString = currentNumber + "";
            boolean isNotSpecial = false;

            for (int position = 0; position < numberAsString.length(); position++) {

                int divider = Integer.parseInt(numberAsString.charAt(position) + "");

                if (divider == 0){
                    isNotSpecial = true;
                    break;
                }
                if (input % divider != 0) {
                    isNotSpecial = true;
                    break;
                }
            }
            if (!isNotSpecial) {
                System.out.printf("%d ", currentNumber);
            }
        }*/
    }
}
