package Basic.moreExercise;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        String lastDigit = getLastDigit(number);
        System.out.print(lastDigit);
    }

    private static String getLastDigit(int number) {
        int lastDigit = number % 10;
        String lastDigitWithWord = "";

        switch (lastDigit) {
            case 0:
                lastDigitWithWord = "zero";
                break;
            case 1:
                lastDigitWithWord = "one";
                break;
            case 2:
                lastDigitWithWord = "two";
                break;
            case 3:
                lastDigitWithWord = "three";
                break;
            case 4:
                lastDigitWithWord = "four";
                break;
            case 5:
                lastDigitWithWord = "five";
                break;
            case 6:
                lastDigitWithWord = "six";
                break;
            case 7:
                lastDigitWithWord = "seven";
                break;
            case 8:
                lastDigitWithWord = "eight";
                break;
            case 9:
                lastDigitWithWord = "nine";
                break;
        }
        return lastDigitWithWord;
    }
}
