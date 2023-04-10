package IntroToJava.Streams_IO;

import java.io.*;

public class ReadBytes_IO_Stream {
    public static void main(String[] arguments) {

        // this streams read and write byte by byte (char by char)

        try ( // try-with-resources -> closed stream automatically
              InputStream fileInputStream = new FileInputStream
                      ("/Users/melissa/Documents/Fundamentals/src/resources/Sample.txt");
              OutputStream fileOutputStream = new FileOutputStream
                      ("/Users/melissa/Documents/Fundamentals/src/resources/OutputFile.txt")
        ) {
            int oneByte = fileInputStream.read();
            while (oneByte != -1) {
                // fileOutputStream.write(oneByte);
                System.out.printf("%s ", Integer.toBinaryString(oneByte));// print bytes
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
