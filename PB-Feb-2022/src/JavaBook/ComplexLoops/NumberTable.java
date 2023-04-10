package JavaBook.ComplexLoops;

import java.util.Scanner;

public class NumberTable {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int currentNum = 1;
        boolean isSecondPart = false;

        for (int row = 1; row <= input; row++) {

            boolean isReachInput = false;

            for (int colum = 1; colum <= input; colum++) {

                if (row == 1) { // 1 ред
                    System.out.print(currentNum + " ");
                    currentNum++;
                } else { // другите редове

                    if (colum == 1) { // първата колона в останалите редове:
                        currentNum = row;
                        System.out.print(currentNum + " ");
                    } else if (currentNum != input && !isReachInput) { // другите колони на останалите редове
                        currentNum += 1;
                        System.out.print(currentNum + " ");
                    } else if (currentNum == input || isSecondPart) {
                        currentNum--;
                        System.out.print(currentNum + " ");
                        isReachInput = true;
                        isSecondPart = true;
                    }
                }
            }
            System.out.println();
        }

       /* for (int row = 0; row < input; row++) {

            for (int colum = 0; colum < input; colum++) {

                int output = row + colum + 1;
                if (output > input) {
                    output = (2 * input) - output;
                }
                System.out.print(output + " ");
            }
            System.out.println();
        } */
    }
}
