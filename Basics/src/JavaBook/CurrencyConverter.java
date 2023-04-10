package JavaBook;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());// сума за конвертиране
        String input = scanner.nextLine();
        String output = scanner.nextLine();

        // курсовете на валутите
        int rateBGN = 1;
        double rateUSD = 1.79549;
        double rateEUR = 1.95583;
        double rateGBP = 2.53405;

        // (sum * rate...(input)) / output

        switch (input) {
            case "BGN":
                sum *= rateBGN;
                break;
            case "USD":
                sum *= rateUSD;
                break;
            case "EUR":
                sum *= rateEUR;
                break;
            case "GBP":
                sum *= rateGBP;
                break;
        }
        switch (output) {
            case "BGN":
                sum /= rateBGN;
                break;
            case "USD":
                sum /= rateUSD;
                break;
            case "EUR":
                sum /= rateEUR;
                break;
            case "GBP":
                sum /= rateGBP;
                break;
        }

        System.out.printf("%.2f %s",sum,output);
    }
}
