package TextProcessing.exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String filePath = scanner.nextLine();

        int indexOfSlash = filePath.lastIndexOf('\\');
        int indexOfDot = filePath.lastIndexOf('.');

        String fileName = filePath.substring(indexOfSlash + 1, indexOfDot);
        String extension = filePath.substring(indexOfDot + 1);

        System.out.printf("File name: %s\n" +
                "File extension: %s", fileName, extension);
    }
}
