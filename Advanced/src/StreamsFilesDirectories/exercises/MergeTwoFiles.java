package StreamsFilesDirectories.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] arguments) throws IOException {


        Path firstPath = Path.of("src/StreamsFilesDirectories/resources_ex/Exercises Resources/inputOne.txt");
        List<String> firstFileLines = Files.readAllLines(firstPath);


        Path secondPath = Path.of("src/StreamsFilesDirectories/resources_ex/Exercises Resources/inputTwo.txt");
        List<String> secondFileLines = Files.readAllLines(secondPath);

        Path outputPath = Path.of("src/StreamsFilesDirectories/resources_ex/Exercises Resources/outputThree");

        Files.write(outputPath,firstFileLines, StandardOpenOption.APPEND);
        Files.write(outputPath,secondFileLines, StandardOpenOption.APPEND);

    }
}
