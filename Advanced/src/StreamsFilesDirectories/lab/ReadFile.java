package StreamsFilesDirectories.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] arguments) {

        // copy path from content root
        String path = "src/StreamsFilesDirectories/resources/input.txt";

        try (InputStream fileStream = new FileInputStream(path)){

            // int, a не byte, защото трябва да има още една стойност,
            // която да се връща когато няма повече байтове

            int oneByte = fileStream.read();
            while (oneByte != -1) {
                String binaryRepresent = Integer.toBinaryString(oneByte);
                System.out.printf("%s ",binaryRepresent);
                oneByte = fileStream.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
