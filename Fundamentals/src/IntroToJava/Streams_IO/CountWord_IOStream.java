package IntroToJava.Streams_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountWord_IOStream {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String filePathName = "/Users/melissa/Documents/Fundamentals/src/resources/Sample.txt";
        String word = scanner.nextLine();
        Scanner fileReader = null;
        int countWord = 0;

        try {
            fileReader = new Scanner(new File(filePathName));
            while (fileReader.hasNext()) {
                String line = fileReader.next();
                int index = line.indexOf(word);
                if (index != -1) {
                    countWord++;
                    index = line.indexOf(word, index + 1);
                }
                fileReader.next();
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File %s is not found + %s", filePathName, e.getLocalizedMessage());
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        System.out.printf("The word: %s is occurs %d times", word, countWord);
    }
}
