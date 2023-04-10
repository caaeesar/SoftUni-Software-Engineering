package StreamsFilesDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LineNumbers {
    public static void main(String[] arguments) {

        String inputPath = "src/StreamsFilesDirectories/resources_ex/inputLineNumbers.txt";
        String outputPath = "src/StreamsFilesDirectories/resources_ex/output.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputPath));
                PrintWriter writer = new PrintWriter(outputPath);
                ) {

            int countLine = 1;
            String currentLine = reader.readLine();
            while (currentLine != null) {

                writer.println(countLine + ". " + currentLine);

                currentLine = reader.readLine();
                countLine++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
