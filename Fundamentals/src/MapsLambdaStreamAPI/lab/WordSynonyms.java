package MapsLambdaStreamAPI.lab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> wordSynonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            List<String> currentSynonymsList = wordSynonyms.computeIfAbsent(word, k -> new ArrayList<>());

            currentSynonymsList.add(synonym);
            wordSynonyms.put(word, currentSynonymsList);

              /* String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            wordSynonyms.putIfAbsent(word,new ArrayList<>());
            wordSynonyms.get(word).add(synonym);*/

            /*List<String> currentSynonymsList = wordSynonyms.get(word);

            if (currentSynonymsList == null) {
                currentSynonymsList = new ArrayList<>();
                wordSynonyms.put(word, currentSynonymsList);
            }
            currentSynonymsList.add(synonym);
          */

         /*      if (currentSynonymsList != null) {
                currentSynonymsList.add(synonym);
            } else {
                currentSynonymsList = new ArrayList<>();
                currentSynonymsList.add(synonym);
                wordSynonyms.put(word, currentSynonymsList);
            }*/

        }

        for (Map.Entry<String, List<String>> entry : wordSynonyms.entrySet()) {

            System.out.printf("%s - %s%n", entry.getKey(),
                    String.join(", ", entry.getValue()));
        }
    }
}
