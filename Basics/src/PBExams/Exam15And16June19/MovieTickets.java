package PBExams.Exam15And16June19;

import java.util.Scanner;

public class MovieTickets {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a1 = Integer.parseInt(scanner.nextLine());
        int a2 = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int symbol1 = a1; symbol1 <= (a2 - 1); symbol1++) {

            for (int symbol2 = 1; symbol2 <= n - 1; symbol2++) {

                for (int symbol3 = 1; symbol3 <= (n / 2 - 1); symbol3++) {

                    boolean firstCondition = symbol1 % 2 != 0;
                    boolean secondCondition = (symbol2 + symbol3 + symbol1) % 2 != 0;

                    if (firstCondition && secondCondition) {
                        System.out.printf("%c-%d%d%d%n", symbol1, symbol2, symbol3, symbol1);
                    }
                }
            }
        }
    }
}
