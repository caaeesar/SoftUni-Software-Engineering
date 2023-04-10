package PBExams.Exam18And19July20;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int fistNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        int firstDigitS = fistNumber / 1000;
        int secondDigitS = (fistNumber / 100) % 10;
        int thirdDigitS = (fistNumber / 10) % 10;
        int forthDigitS = fistNumber % 10;

        int firstDigitE = secondNumber / 1000;
        int secondDigitE = (secondNumber / 100) % 10;
        int thirdDigitE = (secondNumber / 10) % 10;
        int forthDigitE = secondNumber % 10;

        for (int currentFirstDigit = firstDigitS; currentFirstDigit <= firstDigitE; currentFirstDigit++) {

            for (int currentSecondDigit = secondDigitS; currentSecondDigit <= secondDigitE; currentSecondDigit++) {

                for (int currentThirdDigit = thirdDigitS; currentThirdDigit <= thirdDigitE; currentThirdDigit++) {

                    for (int currentForthDigit = forthDigitS; currentForthDigit <= forthDigitE; currentForthDigit++) {

                        boolean isFirstOdd = currentFirstDigit % 2 != 0;
                        boolean isSecondOdd = currentSecondDigit % 2 != 0;
                        boolean isThirdOdd = currentThirdDigit % 2 != 0;
                        boolean isForthOdd = currentForthDigit % 2 != 0;

                        if (isFirstOdd && isSecondOdd && isThirdOdd && isForthOdd) {
                            System.out.printf("%d%d%d%d ", currentFirstDigit, currentSecondDigit, currentThirdDigit, currentForthDigit);
                        }
                        isFirstOdd = false;
                        isSecondOdd = false;
                        isThirdOdd = false;
                        isForthOdd = false;
                    }
                }
            }
        }
    }
}
