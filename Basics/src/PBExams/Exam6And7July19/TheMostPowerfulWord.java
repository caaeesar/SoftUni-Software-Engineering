package PBExams.Exam6And7July19;

import java.util.Scanner;

public class TheMostPowerfulWord {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String currentWord = scanner.nextLine();
        double currentSum = 0.00;
        double maxSum = -2147483647.0;
        String theBestWord = "";

        while (!currentWord.equals("End of words")) {

            for (int position = 0; position < currentWord.length(); position++) {

                char symbol = currentWord.charAt(position);
                currentSum += symbol;
                int length = currentWord.length();

                if (position == currentWord.length() - 1) {

                    char firstSymbol = currentWord.charAt(0);

                    switch (firstSymbol) {
                        case 'a':
                        case 'A':
                        case 'e':
                        case 'E':
                        case 'i':
                        case 'I':
                        case 'o':
                        case 'O':
                        case 'u':
                        case 'U':
                        case 'y':
                        case 'Y':

                            currentSum = Math.floor(currentSum * length);
                            break;
                        default:
                            currentSum = Math.floor(currentSum / length);
                            break;
                    }
                }
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                theBestWord = currentWord;
            }
            currentWord = scanner.nextLine();
            currentSum = 0;
        }
        System.out.printf("The most powerful word is %s - %.0f", theBestWord, maxSum);
    }
}
