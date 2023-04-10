package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class CodeGeneration {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int password = Integer.parseInt(scanner.nextLine());
        int totalCodes = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int symbol1 = 0; symbol1 <= 9; symbol1++) {

            for (int symbol2 = 0; symbol2 <= 9; symbol2++) {

                for (int symbol3 = 0; symbol3 <= 9; symbol3++) {

                    for (char symbol4 = 'a'; symbol4 <= 'z'; symbol4++) {

                        for (char symbol5 = 'a'; symbol5 <= 'z'; symbol5++) {

                            for (int symbol6 = 0; symbol6 <= 9; symbol6++) {

                                int currentSum = symbol1 +
                                        symbol2 +
                                        symbol3 +
                                        symbol4 +
                                        symbol5 +
                                        symbol6;
                                if (currentSum == password) {
                                    count++;
                                    System.out.printf("%d%d%d%c%c%d ", symbol1, symbol2,
                                            symbol3, symbol4,
                                            symbol5, symbol6);
                                }
                                if (count == totalCodes) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
