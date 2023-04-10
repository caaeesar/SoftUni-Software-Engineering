package StreamsFilesDirectories.lab;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] arguments) throws IOException {

        // Paths Files - класове, които имат статични методи

        Path inputPath = Path.of("src/StreamsFilesDirectories/resources/input.txt");
        Path outputPath = Paths.get("src/StreamsFilesDirectories/resources/06.SortLinesOutput.txt");

        List<String> allFileLines = Files.readAllLines(inputPath);

        List<String> sortedLines = allFileLines.stream().sorted().collect(Collectors.toList());

        Files.write(outputPath,sortedLines);

    }
}
