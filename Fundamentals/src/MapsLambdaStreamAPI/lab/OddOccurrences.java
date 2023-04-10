package MapsLambdaStreamAPI.lab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *  List<String> sequenceOfWords = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
         *         Map<String, Integer> wordsCount = new LinkedHashMap<>(sequenceOfWords.size());
         *
         *         for (String word : sequenceOfWords) {
         *             String wordInLowerCase = word.toLowerCase(); // caseInSensitive
         *
         *             if (wordsCount.containsKey(wordInLowerCase)) {
         *                 wordsCount.put(wordInLowerCase, wordsCount.get(wordInLowerCase) + 1);
         *             } else {
         *                 wordsCount.put(wordInLowerCase, 1);
         *             }
         *         }
         *         List<String> oddWordCount = new ArrayList<>();
         *         for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
         *
         *             if (entry.getValue() % 2 != 0) {
         *                 oddWordCount.add(entry.getKey());
         *             }
         *         }
         *         System.out.print(String.join(", ",oddWordCount)); // printInLowerCase
         */

        // 1. input -> case - insensitive (lower Case)
        // 2. put in map -> LinkedHashMap
        // 3. filtering by values (odd)

        String[] sequenceOfWords = scanner.nextLine().toLowerCase().split("\\s");
        Map<String, Integer> wordsOccurrences = new LinkedHashMap<>();

        for (String currentWord : sequenceOfWords) {

            Integer currentOccurrences = wordsOccurrences.get(currentWord);
            if (currentOccurrences == null) {
                currentOccurrences = 0;
            }
            wordsOccurrences.put(currentWord,currentOccurrences + 1);
        }
        String[] filteredWords = (wordsOccurrences.entrySet()
                .stream()
                .filter(e -> e.getValue() % 2 != 0)
                .map(Map.Entry::getKey).toArray(String[]::new));

        System.out.print(String.join(", ",filteredWords));
    }
}
