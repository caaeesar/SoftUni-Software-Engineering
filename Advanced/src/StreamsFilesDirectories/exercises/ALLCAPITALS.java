package StreamsFilesDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ALLCAPITALS {
    public static void main(String[] arguments) throws IOException {

        String inputPath = "src/StreamsFilesDirectories/resources_ex/input.txt";
        String outputPath = "src/StreamsFilesDirectories/resources_ex/output.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
        PrintWriter writer = new PrintWriter(outputPath);

        String currentLine = bufferedReader.readLine();
        while (currentLine != null) {

            for (char symbol : currentLine.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    String upperLetter = String.valueOf(symbol).toUpperCase();
                    writer.write(upperLetter);
                } else {
                    writer.write(symbol);
                }
            }
            currentLine = bufferedReader.readLine();
            writer.write('\n');
        }
        bufferedReader.close();
        writer.close();
    }
}
