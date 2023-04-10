package PBExams.Exam28And29March20;

import java.util.Scanner;

public class ChangeBureau {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int bitcoin = Integer.parseInt(scanner.nextLine());
        double yuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        int bitcoinToLv = bitcoin * 1168;
        double yuanToDollars = yuan * 0.15;
        double yuanToLv = yuanToDollars * 1.76;
        double totalLv = bitcoinToLv + yuanToLv;
        double euro = totalLv / 1.95;
        double sumWithoutCom = euro - (euro * (commission / 100));

        System.out.printf("%.2f", sumWithoutCom);
    }
}
