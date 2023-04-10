package JavaBook.ProblemsForChampionsPart2;

import java.util.Scanner;

public class BullsAndCows {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        //todo 93/100
        int secretNumber = Integer.parseInt(scanner.nextLine());
        int bulls = Integer.parseInt(scanner.nextLine());
        int cows = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int firstNumber = 1; firstNumber <= 9; firstNumber++) {

            for (int secondNumber = 1; secondNumber <= 9; secondNumber++) {

                for (int thirdNumber = 1; thirdNumber <= 9; thirdNumber++) {

                    for (int forthNumber = 1; forthNumber <= 9; forthNumber++) {

                        int firstDigit = secretNumber / 1000;
                        int secondDigit = (secretNumber / 100) % 10;
                        int thirdDigit = (secretNumber / 10) % 10;
                        int forthDigit = secretNumber % 10;

                        int copyFirstNum = firstNumber;
                        int copySecondNum = secondNumber;
                        int copyThirdNum = thirdNumber;
                        int copyForthNum = forthNumber;

                        int countBulls = 0; //същата позиция
                        int countCows = 0; //различна позиция

                        //bulls
                        if (firstDigit == copyFirstNum) {
                            countBulls++;
                            copyFirstNum = 0;
                            firstDigit = -1;
                        }
                        if (secondDigit == copySecondNum) {
                            countBulls++;
                            copySecondNum = 0;
                            secondDigit = -1;
                        }
                        if (thirdDigit == copyThirdNum) {
                            countBulls++;
                            copyThirdNum = 0;
                            thirdDigit = -1;
                        }
                        if (forthDigit == copyForthNum) {
                            countBulls++;
                            copyForthNum = 0;
                            forthDigit = -1;
                        }

                        //cows
                        if (firstDigit == copySecondNum) {
                            countCows++;
                            copySecondNum = 0;

                        } else if (firstDigit == copyThirdNum) {
                            countCows++;
                            copyThirdNum = 0;

                        } else if (firstDigit == copyForthNum) {
                            countCows++;
                            copyForthNum = 0;

                        }

                        if (secondDigit == copyFirstNum) {
                            countCows++;
                            copyFirstNum = 0;

                        } else if (secondDigit == copyThirdNum) {
                            countCows++;
                            copyThirdNum = 0;

                        } else if (secondDigit == copyForthNum) {
                            countCows++;
                            copyForthNum = 0;

                        }

                        if (thirdDigit == copyFirstNum) {
                            countCows++;
                            copyFirstNum = 0;

                        } else if (thirdDigit == copySecondNum) {
                            countCows++;
                            copySecondNum = 0;

                        } else if (thirdDigit == copyForthNum) {
                            countCows++;
                            copyForthNum = 0;

                        }

                        if (forthDigit == copyFirstNum) {
                            countCows++;
                            copyFirstNum = 0;

                        } else if (forthDigit == copySecondNum) {
                            countCows++;
                            copySecondNum = 0;

                        } else if (forthDigit == copyThirdNum) {
                            countCows++;
                            copyThirdNum = 0;

                        }

                        if ((countBulls == bulls) && (countCows == cows)) {
                            System.out.printf("%d%d%d%d ", firstNumber, secondNumber, thirdNumber, forthNumber);
                            isFound = true;
                        }
                    }
                }
            }
        }
        if (!isFound) {
            System.out.println("No");
        }
    }
}
