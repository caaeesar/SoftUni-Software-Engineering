package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class CoinRating {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int participants = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0.00;
        double allSumDOGE = 0.00;
        double allSumIOTA = 0.00;
        double allSumNEO = 0.00;
        double allSumESTD = 0.00;
        int countDOGE = 0;
        int countIOTA = 0;
        int countNEO = 0;
        int countESTD = 0;

        for (int participant = 1; participant <= participants; participant++) {

            String currency = scanner.nextLine();
            double value = Double.parseDouble(scanner.nextLine());

            switch (currency) {

                case "DOGE":
                    totalPrice += (value * 0.07);
                    allSumDOGE += value;
                    countDOGE++;
                    break;
                case "IOTA":
                    totalPrice += (value * 1.44);
                    allSumIOTA += value;
                    countIOTA++;
                    break;
                case "NEO":
                    totalPrice += (value * 28.50);
                    allSumNEO += value;
                    countNEO++;
                    break;
                case "ESTD":
                    totalPrice += (value * 25);
                    allSumESTD += value;
                    countESTD++;
                    break;
            }
        }
        allSumDOGE *= 0.07;
        allSumIOTA *= 1.44;
        allSumNEO *= 28.50;
        allSumESTD *= 25;

        double percentDOGE = (allSumDOGE / totalPrice) * 100;
        double percentIOTA = (allSumIOTA / totalPrice) * 100;
        double percentNEO = (allSumNEO / totalPrice) * 100;
        double percentESTD = (allSumESTD / totalPrice) * 100;

        System.out.printf("Total votes = %d, Money in market = %.2f EUR%n", participants, totalPrice);
        System.out.printf("DOGE's contribution: %.2f%%; People who use DOGE: %d%n", percentDOGE, countDOGE);
        System.out.printf("IOTA's contribution: %.2f%%; People who use IOTA: %d%n", percentIOTA, countIOTA);
        System.out.printf("NEO's  contribution: %.2f%%; People who use NEO: %d%n", percentNEO, countNEO);
        System.out.printf("ESTD's  contribution: %.2f%%; People who use ESTD: %d", percentESTD, countESTD);
    }
}
