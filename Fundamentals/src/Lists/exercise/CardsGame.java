package Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] splitLine1 = scanner.nextLine().split(" ");
        String[] splitLine2 = scanner.nextLine().split(" ");
        List<Integer> deck1 = parseNumbers(splitLine1);
        List<Integer> deck2 = parseNumbers(splitLine2);

        boolean isFirstPlayerIsWinner = false;
        boolean isSecondPlayerIsWinner = false;
        while (!deck1.isEmpty() && !deck2.isEmpty()) {

            int firstPlayerCard = deck1.get(0);
            int secondPlayerCard = deck2.get(0);

            if (firstPlayerCard > secondPlayerCard) {
                deck1.remove(Integer.valueOf(firstPlayerCard));
                deck1.add(firstPlayerCard);
                deck1.add(secondPlayerCard);
                deck2.remove(Integer.valueOf(secondPlayerCard));
            } else if (firstPlayerCard < secondPlayerCard) {
                deck2.remove(Integer.valueOf(secondPlayerCard));
                deck2.add(secondPlayerCard);
                deck2.add(firstPlayerCard);
                deck1.remove(Integer.valueOf(firstPlayerCard));
            } else {
                deck1.remove(Integer.valueOf(firstPlayerCard));
                deck2.remove(Integer.valueOf(secondPlayerCard));
            }

            if (deck1.isEmpty()) {
                isSecondPlayerIsWinner = true;
            } else if (deck2.isEmpty()) {
                isFirstPlayerIsWinner = true;
            }
        }
        if (isFirstPlayerIsWinner) {
            int sum = 0;

            for (int card : deck1) {
                sum += card;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else if (isSecondPlayerIsWinner) {
            int sum = 0;

            for (int card : deck2) {
                sum += card;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }

    static List<Integer> parseNumbers(String[] splitLine) {
        List<Integer> numbers = new ArrayList<>();
        for (String item : splitLine) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }
}
