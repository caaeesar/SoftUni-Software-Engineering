package StreamsFilesDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] arguments) throws IOException {

        String wordsPath = "src/StreamsFilesDirectories/resources_ex/words.txt";
        List<String> allWordsLine = Files.readAllLines(Path.of(wordsPath));
        String textPath = "src/StreamsFilesDirectories/resources_ex/Exercises Resources/text.txt";
        List<String> allTextLines = Files.readAllLines(Path.of(textPath));

        String outputPath = "src/StreamsFilesDirectories/resources_ex/results.txt";
        Map<String, Integer> wordsCount = new TreeMap<>();


        for (String currentLine : allWordsLine) {
            String[] searchWords = currentLine.split("\\s+");
            for (String word : searchWords) {
                wordsCount.put(word, 0);
            }
        }

        for (String currentLine : allTextLines) {
            String[] words = currentLine.split("\\s+");

            for (String word : words) {
                Integer count = wordsCount.get(word);

                if (wordsCount.containsKey(word)) {
                    count++;
                    wordsCount.put(word, count);
                }
            }
        }
        PrintWriter writer = new PrintWriter(outputPath);

        wordsCount
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(word -> writer.println(word.getKey() + " - " + word.getValue()));

        writer.close();
    }
}

