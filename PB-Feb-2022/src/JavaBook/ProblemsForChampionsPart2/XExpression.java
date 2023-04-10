package JavaBook.ProblemsForChampionsPart2;

import java.util.Scanner;

public class XExpression {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        double currentResult = Double.parseDouble(input.charAt(0) + "");
        double currentNumber = 0.00;

        for (int position = 1; position < input.length() - 1; position++) {

            char symbol = input.charAt(position);

                if (symbol >= 48 && symbol <= 57) {

                    currentNumber = Double.parseDouble(symbol + "");
                    currentResult = currentNumber;

                }

                switch (symbol) {
                    case '*':
                        currentResult *= currentNumber;
                        break;
                    case '/':
                        currentResult /= currentNumber;
                        break;
                    case '+':
                        currentResult += currentNumber;
                        break;
                    case '-':
                        currentResult -= currentNumber;
                        break;
                }

            }
        }

    }
