package IntroToJava.Streams_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class PrintText_IO_Stream {
    public static void main(String[] arguments) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        PrintStream fileOutput = new PrintStream("/Users/melissa/Documents/Fundamentals/src/resources/OutputFile.txt");
        fileOutput.println(text); //todo
        fileOutput.close();
    }
}
