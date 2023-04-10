package IntroToJava.Streams_IO;

import java.io.*;

public class CopyBytes {

    public static void main(String[] arguments) {

        String inputPath = "/Users/melissa/Documents/Fundamentals/src/resources/Sample.txt";
        String outputPath = "/Users/melissa/Documents/Fundamentals/src/resources/OutputFile.txt";

        try (InputStream inputStream = new FileInputStream(inputPath);
             OutputStream outputStream = new FileOutputStream(outputPath)) {

            int oneByte = inputStream.read();
            while (oneByte != -1) {

                if (oneByte == ' ' || oneByte == '\n') {
                    outputStream.write(oneByte);
                } else {
                    String asciiCode = String.valueOf(oneByte);
                    for (int index = 0; index < asciiCode.length(); index++) {
                        outputStream.write(asciiCode.charAt(index));
                    }
                }
                oneByte = inputStream.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
