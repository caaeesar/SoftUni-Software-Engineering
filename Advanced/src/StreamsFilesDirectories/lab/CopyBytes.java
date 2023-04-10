package StreamsFilesDirectories.lab;

import java.io.*;

public class CopyBytes {
    public static void main(String[] arguments) {

        String pathInput = "src/StreamsFilesDirectories/resources/input.txt";
        String pathOutput = "src/StreamsFilesDirectories/resources/03.CopyBytesOutput.txt";

        try (InputStream inputStream = new FileInputStream(pathInput);
             OutputStream outputStream = new FileOutputStream(pathOutput)) {

            int oneByte = inputStream.read(); // ascii code
            while (oneByte != -1) {

                if ((char) oneByte == ' ' || (char) oneByte == '\n') {
                    outputStream.write((oneByte));
                } else {
                    String asciiCode = String.valueOf(oneByte);
                    for (int position = 0; position < asciiCode.length(); position++) {
                        char digit = asciiCode.charAt(position);
                        outputStream.write(digit);
                    }
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            e.getStackTrace();
        }

    }
}
