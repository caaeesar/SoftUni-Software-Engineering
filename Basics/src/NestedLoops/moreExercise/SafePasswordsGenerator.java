package NestedLoops.moreExercise;

import java.util.Scanner;

public class SafePasswordsGenerator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int maxPass = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int firstSymbol = 35;
        int secondSymbol = 64;
        boolean isEnough = false;


        for (int thirdSymbol = 1; thirdSymbol <= a; thirdSymbol++) {

            for (int forthSymbol = 1; forthSymbol <= b; forthSymbol++) {

                if (firstSymbol > 55) {
                    firstSymbol = 35;
                }
                if (secondSymbol > 96) {
                    secondSymbol = 64;
                }

                if (count >= maxPass) {
                    isEnough = true;
                    break;
                }

                count++;

                System.out.printf("%c%c%d%d%c%c|", firstSymbol, secondSymbol, thirdSymbol, forthSymbol, secondSymbol,firstSymbol);

                firstSymbol++;
                secondSymbol++;

            }
            if (isEnough) {
                break;
            }
        }

    }
}
