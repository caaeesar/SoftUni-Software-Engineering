package TextProcessing.moreExercise;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int currentLine = 1; currentLine <= lines; currentLine++) {

            String input = scanner.nextLine();

            int indexAtSign = input.indexOf('@');
            int indexPipe = input.indexOf('|');
            String name = input.substring(indexAtSign + 1, indexPipe);

            int indexHash = input.indexOf('#');
            int indexStar = input.indexOf('*');
            String age = input.substring(indexHash + 1, indexStar);

            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
