package WorkingWithAbstraction.exercises.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Card.Rank rank = Card.Rank.valueOf(scanner.nextLine());
        Card.Suit suit = Card.Suit.valueOf(scanner.nextLine());

        Card card = new Card(suit,rank);
        System.out.println(card);
    }
}
