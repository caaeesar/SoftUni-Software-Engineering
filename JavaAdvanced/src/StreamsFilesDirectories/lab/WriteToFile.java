package StreamsFilesDirectories.lab;

import java.io.*;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] arguments) {

        String pathInput = "src/StreamsFilesDirectories/resources/input.txt";
        String pathOutput = "src/StreamsFilesDirectories/resources/02.WriteToFileOutput.txt";
        Set<Character> punctuation = Set.of(',','.','!','?');

        try (InputStream inputStream = new FileInputStream(pathInput);
             OutputStream outputStream = new FileOutputStream(pathOutput)){

            int oneByte = inputStream.read();
            while (oneByte != -1) {

                if (!punctuation.contains((char)oneByte)) {
                    outputStream.write((char)oneByte);
                }

                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
