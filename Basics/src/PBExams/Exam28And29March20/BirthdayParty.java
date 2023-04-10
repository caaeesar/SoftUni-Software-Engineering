package PBExams.Exam28And29March20;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double rentHall = Double.parseDouble(scanner.nextLine());
        double priceCake = rentHall * 0.2;
        double drinks = priceCake - (priceCake * 0.45);
        double animator = rentHall / 3;

        double totalSum = rentHall + priceCake + drinks + animator;
        System.out.printf("%.1f", totalSum);
    }
}
