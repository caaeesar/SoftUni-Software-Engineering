package Exams.MidRetake.MyRetakeExam;

import java.util.Scanner;

public class GiftBoxCoverage {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
//todo 66/100
        double sideSize = Double.parseDouble(scanner.nextLine());
        double giftBoxArea = Math.pow(sideSize, 2) * 6;
        int totalPaper = Integer.parseInt(scanner.nextLine());

        double totalArea = 0.00;
        int countThirdSheet = 0;
        int countFifthSheet = 0;
        double currentArea = 0.00;

        for (int currentSheetInfo = 1; currentSheetInfo <= totalPaper; currentSheetInfo++) {

            double length = Double.parseDouble(scanner.nextLine());
            double width = Double.parseDouble(scanner.nextLine());
            countThirdSheet++;
            countFifthSheet++;

            if (countThirdSheet == 3) {
                countThirdSheet = 0;
                currentArea = (length * width) - ((length * width) * 0.25);
                totalArea += currentArea;
                continue;
            }
            if (countFifthSheet == 5) {
                countFifthSheet = 0;
                continue;
            }
            currentArea = length * width;
            totalArea += currentArea;
        }

        if (totalArea > giftBoxArea) {
            double percentage = ((totalArea - giftBoxArea) / totalArea) * 100;
            System.out.println("You've covered the gift box!");
            System.out.printf("%.2f%% wrap paper left.", percentage);
        } else if (totalArea < giftBoxArea){
            double percentage = (totalArea / giftBoxArea) * 100;
            System.out.println("You are out of paper!");
            System.out.printf("%.2f%% of the box is not covered.", 100 - percentage);
        } else {
            System.out.println("You've covered the gift box!");
            System.out.print("0.00% wrap paper left.");
        }
    }
}
