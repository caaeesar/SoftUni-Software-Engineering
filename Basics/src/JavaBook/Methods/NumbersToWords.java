package JavaBook.Methods;

import java.util.Scanner;

public class NumbersToWords {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int currentNum = 1; currentNum <= n; currentNum++) {

            int currentNumber = Integer.parseInt(scanner.nextLine());

            if (currentNumber < -999) {
                System.out.println("too small");
            } else if (currentNumber > 999) {
                System.out.println("too large");
            } else if ((currentNumber >= 1 && currentNumber <= 99)
                    || (currentNumber <= -1 && currentNumber >= -99)) {
                continue;
            } else {
                System.out.println(numbersToWords(currentNumber));
            }
        }
    }

    static String numbersToWords(int number) {

        String result = "";

        if (number < 0) {
            result += "minus ";
        }
        int firstDigit = Math.abs(number / 100);
        int secondDigit = Math.abs((number / 10) % 10);
        int thirdDigit = Math.abs(number % 10);


        switch (firstDigit) {

            case 1:
                result += "one-hundred";
                break;
            case 2:
                result += "two-hundred";
                break;
            case 3:
                result += "three-hundred";
                break;
            case 4:
                result += "four-hundred";
                break;
            case 5:
                result += "five-hundred";
                break;
            case 6:
                result += "six-hundred";
                break;
            case 7:
                result += "seven-hundred";
                break;
            case 8:
                result += "eight-hundred";
                break;
            case 9:
                result += "nine-hundred";
                break;
        }

        if (secondDigit == 0 && thirdDigit == 0) {
            return result;
        } else if (secondDigit == 0) {

            result += " and ";

            switch (thirdDigit) {

                case 1:
                    result += "one";
                    break;
                case 2:
                    result += "two";
                    break;
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "eight";
                    break;
                case 9:
                    result += "nine";
                    break;
            }
        }
        if (secondDigit == 1) {

            result += " and ";

            switch (thirdDigit) {
                case 1:
                    result += "eleven";
                    break;
                case 2:
                    result += "twelve";
                    break;
                case 3:
                    result += "thirteen";
                    break;
                case 4:
                    result += "fourteen";
                    break;
                case 5:
                    result += "fifteen";
                    break;
                case 6:
                    result += "sixteen";
                    break;
                case 7:
                    result += "seventeen";
                    break;
                case 8:
                    result += "eighteen";
                    break;
                case 9:
                    result += "nineteen";
                    break;

            }
        }

        if (secondDigit >= 2) {

            result += " and ";

            switch (secondDigit) {
                case 2:
                    result += "twenty";
                    break;
                case 3:
                    result += "thirty";
                    break;
                case 4:
                    result += "forty";
                    break;
                case 5:
                    result += "fifty";
                    break;
                case 6:
                    result += "sixty";
                    break;
                case 7:
                    result += "seventy";
                    break;
                case 8:
                    result += "eighty";
                    break;
                case 9:
                    result += "ninety";
                    break;
            }

            switch (thirdDigit) {
                case 1:
                    result += " one";
                    break;
                case 2:
                    result += " two";
                    break;
                case 3:
                    result += " three";
                    break;
                case 4:
                    result += " four";
                    break;
                case 5:
                    result += " five";
                    break;
                case 6:
                    result += " six";
                    break;
                case 7:
                    result += " seven";
                    break;
                case 8:
                    result += " eight";
                    break;
                case 9:
                    result += " nine";
                    break;
            }
        }
        return result;
    }

}
