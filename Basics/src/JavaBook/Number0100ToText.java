package JavaBook;

import java.util.Scanner;

public class Number0100ToText {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine()); // {от 0 до 100}
        String teen = "teen";
        String ty = "ty";

        if ((number >= 0) && (number <= 12)) {

            switch (number) {
                case 0:
                    System.out.print("zero");
                    break;
                case 1:
                    System.out.print("one");
                    break;
                case 2:
                    System.out.print("two");
                    break;
                case 3:
                    System.out.print("three");
                    break;
                case 4:
                    System.out.print("four");
                    break;
                case 5:
                    System.out.print("five");
                    break;
                case 6:
                    System.out.print("six");
                    break;
                case 7:
                    System.out.print("seven");
                    break;
                case 8:
                    System.out.print("eight");
                    break;
                case 9:
                    System.out.print("nine");
                    break;
                case 10:
                    System.out.print("ten");
                    break;
                case 11:
                    System.out.print("eleven");
                    break;
                case 12:
                    System.out.print("twelve");
                    break;
            }
        } else if ((number > 12) && (number <= 19)) {
            int secondDigit = number % 10;

            switch (secondDigit) {
                case 3:
                    System.out.print("thir" + teen);
                    break;
                case 4:
                    System.out.print("four" + teen);
                    break;
                case 5:
                    System.out.print("fif" + teen);
                    break;
                case 6:
                    System.out.print("six" + teen);
                    break;
                case 7:
                    System.out.print("seven" + teen);
                    break;
                case 8:
                    System.out.print("eight" + teen);
                    break;
                case 9:
                    System.out.print("nine" + teen);
                    break;
            }
        } else if ((number >= 20) && (number <= 99)) {
            int firstDigit = number / 10;
            int secondDigit = number % 10;

            switch (firstDigit) {
                case 2:
                    System.out.print("twen" + ty);
                    break;
                case 3:
                    System.out.print("thir" + ty);
                    break;
                case 4:
                    System.out.print("for" + ty);
                    break;
                case 5:
                    System.out.print("fif" + ty);
                    break;
                case 6:
                    System.out.print("six" + ty);
                    break;
                case 7:
                    System.out.print("seven" + ty);
                    break;
                case 8:
                    System.out.print("eigh" + ty);
                    break;
                case 9:
                    System.out.print("nine" + ty);
                    break;
            }
            switch (secondDigit) {
                case 1:
                    System.out.print(" one");
                    break;
                case 2:
                    System.out.print(" two");
                    break;
                case 3:
                    System.out.print(" three");
                    break;
                case 4:
                    System.out.print(" four");
                    break;
                case 5:
                    System.out.print(" five");
                    break;
                case 6:
                    System.out.print(" six");
                    break;
                case 7:
                    System.out.print(" seven");
                    break;
                case 8:
                    System.out.print(" eight");
                    break;
                case 9:
                    System.out.print(" nine");
                    break;
            }
        } else if (number == 100) {
            System.out.print("one hundred");
        } else {
            System.out.print("Invalid number");
        }
    }
}
