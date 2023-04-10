package IntroToJava.Streams_IO;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] arguments) {

        String inputPath = "/Users/melissa/Documents/Fundamentals/src/resources/Sample.txt";
        String outPath = "/Users/melissa/Documents/Fundamentals/src/resources/OutputFile.txt";

        try (
                Scanner fileReader = new Scanner(new FileInputStream(inputPath));
                PrintWriter fileWriter = new PrintWriter(new FileOutputStream(outPath))
        ) {
            while (fileReader.hasNext()) {
                if (fileReader.hasNextInt()) {
                int digit = fileReader.nextInt();
                fileWriter.println(digit);
                }
                fileReader.next();
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
