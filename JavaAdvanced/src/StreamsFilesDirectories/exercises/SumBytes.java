package StreamsFilesDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] arguments) {

        String path = "src/StreamsFilesDirectories/resources_ex/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            long sum = 0;
            String currentLine = reader.readLine();
            while (currentLine != null) {
                for (char symbol : currentLine.toCharArray()) {
                    sum += symbol;
                }
                currentLine = reader.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
