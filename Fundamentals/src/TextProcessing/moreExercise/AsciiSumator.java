package TextProcessing.moreExercise;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int firstSymbolCode = scanner.nextLine().charAt(0);
        int secondSymbolCode = scanner.nextLine().charAt(0);
        int start;
        int end;
        String str = scanner.nextLine();

        if (firstSymbolCode > secondSymbolCode) {
            start = secondSymbolCode;
            end = firstSymbolCode;
        } else {
            start = firstSymbolCode;
            end = secondSymbolCode;
        }

        int sum = 0;
        for (int index = 0; index < str.length(); index++) {

            char symbol = str.charAt(index);
            if (symbol > start && symbol < end) {
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
