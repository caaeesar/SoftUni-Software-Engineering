package SetsAndMaps.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 50;
        while (round-- > 0 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {


            int firstCard = firstDeck.iterator().next();
            firstDeck.remove(firstCard);

            int secondCard = secondDeck.iterator().next();
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }
        if (firstDeck.size() == secondDeck.size()) {
            System.out.print("Draw!");
        } else if (firstDeck.size() > secondDeck.size()) {
            System.out.print("First player win!");
        } else {
            System.out.print("Second player win!");
        }
    }
}
