package PBExams.Exam6And7April19;

import java.util.Scanner;

public class OscarsCeremony {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int rent = Integer.parseInt(scanner.nextLine());
        double statuette = rent - (rent * 0.3);
        double catering = statuette - (statuette * 0.15);
        double music = catering / 2;

        double totalSum = rent + statuette + catering + music;

        System.out.printf("%.2f", totalSum);
    }
}
