package ObjectsAndClasses.lab;

import java.util.*;

public class RandomizeWords {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * String[] words = Arrays.stream(scanner.nextLine().split("\\s+")).toArray(String[]::new);
         *
         *      Random rgn = new Random();
         *
         *         for (int position = 0; position < words.length; position++) {
         *
         *             int index = rgn.nextInt(words.length);
         *
         *             String currentWord = words[position];
         *             words[position] = words[index];
         *             words[index] = currentWord;
         *
         *         }
         *         Arrays.stream(words).forEach(System.out::println);
         */

        List<String> words = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        Random random = new Random();

        for (int index = 0; index < words.size(); index++) {

            int randomIndex = random.nextInt(words.size()); // not include
            String randomElement = words.get(randomIndex);
            words.remove(randomElement);
            words.add(randomElement);
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}
