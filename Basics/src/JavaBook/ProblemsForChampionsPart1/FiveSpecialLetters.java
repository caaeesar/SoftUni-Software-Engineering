package JavaBook.ProblemsForChampionsPart1;

import java.util.Scanner;

public class FiveSpecialLetters {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        StringBuilder currentSymbols = new StringBuilder();
        int currentWeight = 0;

        boolean isFirstA = true;
        boolean isFirstB = true;
        boolean isFirstC = true;
        boolean isFirstD = true;
        boolean isFirstE = true;

        boolean isHave = false;
        int countSymbols = 0;

        char symbol1 = 'a';
        while (symbol1 <= 'e') {

            char symbol2 = 'a';
            while (symbol2 <= 'e') {

                char symbol3 = 'a';
                while (symbol3 <= 'e') {

                    char symbol4 = 'a';
                    while (symbol4 <= 'e') {

                        char symbol5 = 'a';
                        while (symbol5 <= 'e') {

                            currentSymbols.append(symbol1)
                                    .append(symbol2)
                                    .append(symbol3).
                                    append(symbol4)
                                    .append(symbol5);

                            for (int position = 0; position < currentSymbols.length(); position++) {

                                char symbol = currentSymbols.charAt(position);

                                if (symbol == 'a') {
                                    if (isFirstA) {

                                        int weight = 5;
                                        isFirstA = false;
                                        currentWeight += (weight * ((position + 1) - countSymbols));

                                    } else {
                                        countSymbols++;
                                    }
                                } else if (symbol == 'b') {
                                    if (isFirstB) {

                                        isFirstB = false;
                                        int weight = -12;
                                        currentWeight += (weight * ((position + 1) - countSymbols));

                                    } else {
                                        countSymbols++;
                                    }
                                } else if (symbol == 'c') {
                                    if (isFirstC) {

                                        isFirstC = false;
                                        int weight = 47;
                                        currentWeight += (weight * ((position + 1) - countSymbols));

                                    } else {
                                        countSymbols++;
                                    }
                                } else if (symbol == 'd') {
                                    if (isFirstD) {

                                        isFirstD = false;
                                        int weight = 7;
                                        currentWeight += (weight * ((position + 1) - countSymbols));

                                    } else {
                                        countSymbols++;
                                    }
                                } else if (symbol == 'e') {
                                    if (isFirstE) {

                                        isFirstE = false;
                                        int weight = -32;
                                        currentWeight += (weight * ((position + 1) - countSymbols));

                                    } else {
                                        countSymbols++;
                                    }
                                }
                            }
                            if (currentWeight >= start && currentWeight <= end) {

                                isHave = true;
                                System.out.printf("%s ", currentSymbols);
                            }
                            isFirstA = true;
                            isFirstB = true;
                            isFirstC = true;
                            isFirstD = true;
                            isFirstE = true;
                            currentSymbols = new StringBuilder();
                            currentWeight = 0;
                            countSymbols = 0;
                            symbol5++;
                        }
                        symbol4++;
                    }
                    symbol3++;
                }
                symbol2++;
            }
            symbol1++;
        }
        if (!isHave) {
            System.out.println("No");
        }
    }
}
