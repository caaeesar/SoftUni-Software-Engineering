package Exams.Final.MyExam;

import java.util.*;

public class Dictionary {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> noteBook = new LinkedHashMap<>();
        String[] allWordDef = scanner.nextLine().split(" \\| ");

        for (String wordDefinition : allWordDef) {

            String word = wordDefinition.split(": ")[0].replaceAll("[\\[\\]]", "");
            String definition = wordDefinition.split(": ")[1].replaceAll("[\\[\\]]", "");

            List<String> currentDefList = noteBook.get(word);

            if (currentDefList == null) {
                currentDefList = new ArrayList<>();
            }
            currentDefList.add(definition);
            noteBook.put(word, currentDefList);
        }

        String[] testedWords = scanner.nextLine().split(" \\| ");
        String command = scanner.nextLine();
        if (command.equals("Test")) {
            for (String currentWord : testedWords) {
                if (noteBook.containsKey(currentWord)) {
                    List<String> currentDefList = noteBook.get(currentWord);
                    System.out.printf("%s:\n", currentWord);
                    for (String def : currentDefList) {
                        System.out.printf(" -%s\n", def
                        );
                    }
                }
            }
        } else if (command.equals("Hand Over")) {
            noteBook.forEach((key, value) -> System.out.printf("%s ", key));
        }
    }
}
