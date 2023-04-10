package SetsAndMaps.exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> peopleTotalPoints = new LinkedHashMap<>();
        Map<String, Set<String>> peopleDeck = getMapWithPeopleDeck(scanner);

        for (Map.Entry<String, Set<String>> entry : peopleDeck.entrySet()) {

            String personName = entry.getKey();
            Set<String> currentDeck = entry.getValue();

            int value = calculateValue(currentDeck);
            Integer currentValue = peopleTotalPoints.get(personName);
            if (currentValue != null) {
                peopleTotalPoints.put(personName, currentValue + value);
            } else {
                peopleTotalPoints.put(personName, value);
            }
        }
        peopleTotalPoints.forEach((name, values) -> System.out.printf("%s: %d\n", name, values));
    }

    private static Map<String, Set<String>> getMapWithPeopleDeck(Scanner scanner) {
        Map<String, Set<String>> peopleDeck = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"JOKER".equals(input)) {

            String personName = input.split(":")[0];
            String[] parts = input.substring(personName.length() + 2).split(", ");
            Set<String> deck = new HashSet<>(List.of(parts));
            Set<String> currentDeck = peopleDeck.get(personName);
            if (currentDeck != null) {
                currentDeck.addAll(deck);
            } else {
                peopleDeck.put(personName, deck);
            }
            input = scanner.nextLine();
        }
        return peopleDeck;
    }

    private static int calculateValue(Set<String> deck) {
        int totalValue = 0;
        for (String card : deck) {

            Pattern pattern = Pattern.compile("(?<power>[\\d]+|[A-Z])(?<type>[A-Z])");
            Matcher matcher = pattern.matcher(card);

            String power = "";
            String type = "";

            while (matcher.find()) {
                power = matcher.group("power");
                type = matcher.group("type");
            }

            switch (power) {
                case "J":
                    power = "11";
                    break;
                case "Q":
                    power = "12";
                    break;
                case "K":
                    power = "13";
                    break;
                case "A":
                    power = "14";
                    break;
            }

            switch (type) {
                case "S":
                    type = "4";
                    break;
                case "H":
                    type = "3";
                    break;
                case "D":
                    type = "2";
                    break;
                case "C":
                    type = "1";
                    break;
            }
            int currentCardValue = (Integer.parseInt(power) * Integer.parseInt(type));
            totalValue += currentCardValue;
        }
        return totalValue;
    }
}
