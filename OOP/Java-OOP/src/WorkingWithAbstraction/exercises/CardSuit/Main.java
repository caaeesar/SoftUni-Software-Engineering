package WorkingWithAbstraction.exercises.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Suits[] allSuits = Suits.values();

        System.out.println(input + ":");
        for (Suits current : allSuits) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",current.ordinal(),current.name());
        }

    }
}
