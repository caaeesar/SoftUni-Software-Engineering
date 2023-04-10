package JavaBook.ComplexLoopsExamProblems;

import java.util.Scanner;

public class MagicCombination {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int magicNumber = Integer.parseInt(scanner.nextLine());

        for (int firstNumber = 1; firstNumber <= 9; firstNumber++) {

            for (int secondNumber = 1; secondNumber <= 9; secondNumber++) {

                for (int thirdNumber = 1; thirdNumber <= 9; thirdNumber++) {

                    for (int forthNumber = 1; forthNumber <= 9; forthNumber++) {

                        for (int fifthNumber = 1; fifthNumber <= 9; fifthNumber++) {

                            for (int sixthNumber = 1; sixthNumber <= 9; sixthNumber++) {

                                boolean isValid = firstNumber *
                                        secondNumber *
                                        thirdNumber *
                                        forthNumber *
                                        fifthNumber *
                                        sixthNumber == magicNumber;

                                if (isValid) {
                                    System.out.printf("%d%d%d%d%d%d ", firstNumber, secondNumber, thirdNumber, forthNumber, fifthNumber, sixthNumber);
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}
