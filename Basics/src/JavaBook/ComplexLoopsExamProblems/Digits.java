package JavaBook.ComplexLoopsExamProblems;

import java.util.Scanner;

public class Digits {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int copyNumber = number;
        int thirdDigit = copyNumber % 10;
        copyNumber /= 10;
        int secondDigit = copyNumber % 10;
        copyNumber /= 10;
        int firstDigit = copyNumber % 10;

        for (int row = 1; row <= (firstDigit + secondDigit); row++) {

            for (int colum = 1; colum <= (firstDigit + thirdDigit); colum++) {

                if (number % 5 == 0) {

                    number -= firstDigit;

                } else if (number % 3 == 0) {

                    number -= secondDigit;

                } else {

                    number += thirdDigit;

                }
                System.out.printf("%d ", number);
            }
            System.out.println();
        }
    }
}
