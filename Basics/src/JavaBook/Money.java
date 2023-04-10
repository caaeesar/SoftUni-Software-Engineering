package JavaBook;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //• 1 биткойн = 1168 лева.
        //• 1 китайски юан = 0.15 долара.
        //• 1 долар = 1.76 лева.
        //• 1 евро = 1.95 лева.

        // комисионна 0 до 5 % от крайната сума в евро

        int bitcoins = Integer.parseInt(scan.nextLine());
        double yuan = Double.parseDouble(scan.nextLine());
        double commission = Double.parseDouble(scan.nextLine());

        int bitcoinToLv = bitcoins * 1168;
        double yuanToUSD = yuan * 0.15;
        double usdToLv = yuanToUSD * 1.76;

       double totalLv = bitcoinToLv + usdToLv;
       double lvToEur = totalLv / 1.95;
       double result = lvToEur - ((lvToEur * (commission / 100)));
       System.out.println(result);

    }
}
