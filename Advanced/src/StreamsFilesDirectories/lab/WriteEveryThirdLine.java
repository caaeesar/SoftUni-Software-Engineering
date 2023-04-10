package StreamsFilesDirectories.lab;

import java.io.*;
import java.nio.Buffer;

public class WriteEveryThirdLine {
    public static void main(String[] arguments) {

        String inputPath = "src/StreamsFilesDirectories/resources/input.txt";
        String outputPath = "src/StreamsFilesDirectories/resources/05.WriteEveryThirdLineOutput.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputPath));
                PrintWriter writer = new PrintWriter(outputPath);

                ){

            int countLines = 1;
          String currentLine = reader.readLine();
          while (currentLine != null) {

              if (countLines % 3 == 0) {
                writer.println(currentLine);
              }

              currentLine = reader.readLine();
              countLines++;
          }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
