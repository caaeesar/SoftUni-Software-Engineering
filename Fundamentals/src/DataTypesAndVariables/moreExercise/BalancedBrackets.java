package DataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        int countOpenBracket = 0;
        int countCloseBracket = 0;
        boolean isBalanced = true;

        for (int currentLine = 1; currentLine <= lines; currentLine++) {

            String input = scanner.nextLine();

            switch (input) {
                case "(":
                    countOpenBracket++;
                    break;
                case ")":
                    if (countOpenBracket == 0) {
                        isBalanced = false;
                    } else {
                        countCloseBracket++;
                    }
                    break;
            }
            if (countOpenBracket == 1 && countCloseBracket == 1 && isBalanced) {
                countOpenBracket = 0;
                countCloseBracket = 0;
            }
        }
        if (countOpenBracket == 0 && countCloseBracket == 0 && isBalanced) {
            System.out.print("BALANCED");
        } else {
            System.out.print("UNBALANCED");
        }
    }
}
