package IntroToJava.Streams_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile_IO_Streams {
    public static void main(String[] arguments) {
                            // path + file name + extension
        String filePath = "/Users/melissa/Documents/Fundamentals/src/resources/Sample.txt";
        Scanner fileReader = null;

        try {
            fileReader = new Scanner(new File(filePath));
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
        } catch (FileNotFoundException exception) {
            System.out.printf("File %s not found%n", filePath);
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
}
