package IntroToJava.Streams_IO;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] arguments) {

        String inputPath = "/Users/melissa/Documents/Fundamentals/src/resources/Sample.txt";
        String outPath = "/Users/melissa/Documents/Fundamentals/src/resources/OutputFile.txt";

        try (
        BufferedReader fileReader = new BufferedReader(new FileReader(inputPath));
        PrintWriter fileWriter = new PrintWriter(new FileWriter(outPath))
                ){
            String currentLine = fileReader.readLine();
            int countLines = 1;
            while (currentLine != null) {
                if (countLines % 3 == 0) {
                    fileWriter.println(currentLine);
                }
                countLines++;
                currentLine = fileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Really bad");
        }

    }
}
