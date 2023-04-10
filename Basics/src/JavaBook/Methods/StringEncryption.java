package JavaBook.Methods;

import java.util.Scanner;

public class StringEncryption {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int currentSymbol = 1; currentSymbol <= n; currentSymbol++) {

            char symbol = scanner.nextLine().charAt(0);
            System.out.print(encrypt(symbol));
        }
    }

    static String encrypt(char letter) {

        String result = "";
        int firstDigit = 0;
        int lastDigit = 0;

        int asciiCode = letter;

        if (asciiCode >= 100) {

            firstDigit = asciiCode / 100;
            lastDigit = asciiCode % 10;

        } else {

            firstDigit = asciiCode / 10;
            lastDigit = asciiCode % 10;
        }

        int firstPart = Integer.parseInt(asciiCode + lastDigit + "");

        result += (char) firstPart;
        result += firstDigit;
        result += lastDigit;

        int secondPart = Integer.parseInt(asciiCode - firstDigit + "");

        result += (char) secondPart;

        return result;
    }
}
