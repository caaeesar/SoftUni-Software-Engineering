package StreamsFilesDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] arguments) {

        String path = "src/StreamsFilesDirectories/resources_ex/input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String currentLine = reader.readLine();
            while (currentLine != null) {
                int sum = 0;
                for (char symbol : currentLine.toCharArray()) {
                    sum += symbol;
                }
                System.out.println(sum);
                currentLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
