package NestedLoops.moreExercise;

import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        for (int firstSymbol = 1; firstSymbol <= x; firstSymbol++) {

            for (int secondSymbol = 1; secondSymbol <= x; secondSymbol++) {

                for (char thirdSymbol = 97; thirdSymbol < 97 + y; thirdSymbol++) {

                    for (char forthSymbol = 97; forthSymbol < 97 + y; forthSymbol++) {

                        for (int fifthSymbol = 1; fifthSymbol <= x; fifthSymbol++){

                            if (fifthSymbol > firstSymbol && fifthSymbol > secondSymbol) {

                                System.out.printf("%d%d%c%c%d ", firstSymbol, secondSymbol, thirdSymbol, forthSymbol, fifthSymbol);
                            }
                        }
                    }
                }
            }
        }
    }
}
