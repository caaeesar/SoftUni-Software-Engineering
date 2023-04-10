package IntroToJava.Streams_IO;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {

    public static void main(String[] arguments) {

        String inputPath = "/Users/melissa/Documents/Fundamentals/src/resources/Sample.txt";
        String outputPath = "/Users/melissa/Documents/Fundamentals/src/resources/OutputFile.txt";

        try (InputStream inputStream = new FileInputStream(inputPath);
             OutputStream outputStream = new FileOutputStream(outputPath)
        ) {
            Set<Character> punctuation = new HashSet<>();
            Collections.addAll(punctuation, ',', '?', '!', '.', '"');

            int oneByte = inputStream.read();
            while (oneByte != -1) {
                char currentSymbol = (char) oneByte;
                if (!punctuation.contains(currentSymbol)) {
                    outputStream.write(currentSymbol);
                }
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
