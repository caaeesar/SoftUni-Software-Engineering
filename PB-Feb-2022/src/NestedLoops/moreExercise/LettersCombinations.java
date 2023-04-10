package NestedLoops.moreExercise;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        char begin = scanner.nextLine().charAt(0);
        char end = scanner.nextLine().charAt(0);
        char skip = scanner.nextLine().charAt(0);
        int count = 0;


        for (char firstLetter = begin; firstLetter <= end; firstLetter++) {

            for (char secondLetter = begin; secondLetter <= end; secondLetter++) {

                for (char thirdLetter = begin; thirdLetter <= end; thirdLetter++) {

                    if (firstLetter != skip && secondLetter != skip && thirdLetter != skip) {
                        count++;
                        System.out.printf("%c%c%c ", firstLetter, secondLetter, thirdLetter );
                    }

                    if (firstLetter == end && secondLetter == end && thirdLetter == end) {
                        System.out.print(count);
                    }
                }
            }
        }
    }
}
