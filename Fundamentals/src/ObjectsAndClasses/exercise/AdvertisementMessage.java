package ObjectsAndClasses.exercise;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] phrases = new String[]{
                "Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."
        };
        String[] events = new String[]{
                "Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"
        };
        String[] authors = new String[]{
                "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"
        };
        String[] cities = new String[]{
                "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
        };
        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        for (int currentMessage = 1; currentMessage <= numberOfMessages; currentMessage++) {

            String[] message = new String[4];
            int randomPhrase = random.nextInt(phrases.length);
            int randomEvent = random.nextInt(events.length);
            int randomAuthors = random.nextInt(authors.length);
            int randomCities = random.nextInt(cities.length);

            message[0] = phrases[randomPhrase];
            message[1] = events[randomEvent];
            message[2] = authors[randomAuthors];
            message[3] = cities[randomCities];

            System.out.printf("%s %s %s – %s.%n", message[0], message[1], message[2], message[3]);
        }
    }
}
