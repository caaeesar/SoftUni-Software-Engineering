package StreamsFilesDirectories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] arguments) {

        String inputPath = "src/StreamsFilesDirectories/resources/input.txt";
        String outputPath = "src/StreamsFilesDirectories/resources/04.ExtractIntegersOutput.txt";

        try (
                Scanner scanner = new Scanner(new FileInputStream(inputPath));
                PrintStream printStream = new PrintStream(outputPath);
        ) {
            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {
                    int digit = scanner.nextInt();
                    printStream.println(digit);
                }

               scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
