package WorkingWithAbstraction.exercises.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {

        String input =  new Scanner(System.in).nextLine();
        System.out.println(input + ":");

        Cards[] allCards = Cards.values();

        for (Cards card : allCards) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",
                    card.value, card);
        }
    }
}
