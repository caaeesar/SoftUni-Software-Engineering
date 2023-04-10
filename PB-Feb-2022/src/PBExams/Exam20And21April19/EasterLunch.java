package PBExams.Exam20And21April19;

import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int easterBread = Integer.parseInt(scanner.nextLine());
        int eggshells = Integer.parseInt(scanner.nextLine());
        int kgCookies = Integer.parseInt(scanner.nextLine());
        double pricePaint = (eggshells * 12) * 0.15;

        double totalSum = (easterBread * 3.20) + (eggshells * 4.35) + (kgCookies * 5.40) + pricePaint;
        System.out.printf("%.2f", totalSum);
    }
}
