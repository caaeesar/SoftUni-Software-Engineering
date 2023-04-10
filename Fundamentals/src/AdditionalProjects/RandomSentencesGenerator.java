package AdditionalProjects;

import java.util.Random;
import java.util.Scanner;

public class RandomSentencesGenerator {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        String[] names = new String[]{"Melissa", "Georgi", "Steve", "Peter", "Julia","Michell"};
        String[] places = new String[]{"Sofia", "Plovdiv", "Varna", "Burgas"};
        String[] verbs = new String[]{"eats", "holds", "sees", "plays with", "brings"};
        String[] nouns = new String[]{"stones", "cake", "apple", "laptop", "bikes"};
        String[] adverbs = new String[]{"slowly", "diligently", "warmly", "sadly", "rapidly"};
        String[] details = new String[]{"near the river", "at home", "in the park"};

        while (true) {

            String randomName = getRandomWord(names);
            String randomPlace = getRandomWord(places);
            String randomVerb = getRandomWord(verbs);
            String randomNoun = getRandomWord(nouns);
            String randomAdverb = getRandomWord(adverbs);
            String randomDetail = getRandomWord(details);

            String whoFromWhere = String.format("%s from %s ",randomName,randomPlace);
            String action = String.format("%s %s %s ", randomAdverb,randomVerb,randomNoun);
            String detail = String.format("%s.",randomDetail);
            String sentence = whoFromWhere + action + detail;

            System.out.println("Click [Enter] to generate random-generated sentence:");
            String empty = scanner.nextLine();
            if (empty.equals("")) {
                System.out.println(sentence);
            }
        }
    }

    private static String getRandomWord(String[] words) {
        Random rng = new Random();
        int randomIndex = rng.nextInt(words.length);
        return words[randomIndex];
    }
}
