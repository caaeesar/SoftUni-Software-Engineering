package StreamsFilesDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes {
    public static void main(String[] arguments) throws IOException {

        String inputPath = "src/StreamsFilesDirectories/resources_ex/input.txt";
        String outputPath = "src/StreamsFilesDirectories/resources_ex/output.txt";

        BufferedReader reader = null;
        PrintWriter writer = null;

        int vowels = 0;
        int symbols = 0;
        int punctuation = 0;

        try {

            reader = new BufferedReader(new FileReader(inputPath));
            writer = new PrintWriter(outputPath);

            String currentLine = reader.readLine();
            while (currentLine != null) {

                for (char symbol : currentLine.toCharArray()) {

                    if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                        vowels++;
                    } else if (symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?') {
                        punctuation++;
                    } else {
                        if (symbol != ' ') {
                            symbols++;
                        }
                    }

                }
                currentLine = reader.readLine();
            }
            writer.printf("Vowels: %d\n",vowels);
            writer.printf("Other symbols: %d\n",symbols);
            writer.printf("Punctuation: %d",punctuation);

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (reader != null) ;
            {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }


    }
}
