package NestedLoops.moreExercise;

import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int controlValue = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        boolean isHave = false;
        int copyA = 0;
        int copyB = 0;
        int copyC = 0;
        int copyD = 0;
        /*
        String password = "";
         */

        for (int a = 1; a <= 9; a++) {

            for (int b = 1; b <= 9; b++) {

                for (int c = 1; c <= 9; c++) {

                    for (int d = 1; d <= 9; d++) {

                        boolean firstCondition = a < b;
                        boolean secondCondition = c > d;
                        boolean thirdCondition = ((a * b) + (c * d) == controlValue);

                        if (firstCondition && secondCondition && thirdCondition) {
                            counter++;
                            isHave = true;
                            System.out.printf("%d%d%d%d ", a, b, c, d);
                            if (counter == 4) {
                                copyA = a;
                                copyB = b;
                                copyC = c;
                                copyD = d;
                            }
                            /*
                             if (combination == 4) {
                                password = a + "" + b + c + d;
                                isHave = true;
                            }
                             */
                        }
                    }
                }
            }
        }

        if (!isHave || counter < 4) {
            System.out.print("\nNo!");
        } else {
            System.out.printf("\nPassword: %d%d%d%d", copyA, copyB, copyC, copyD); // System.out.printf("\nPassword: %s",password);
        }
    }
}
