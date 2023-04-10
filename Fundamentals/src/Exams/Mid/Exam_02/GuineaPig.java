package Exams.Mid.Exam_02;

import java.util.Scanner;

public class GuineaPig {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //1 kg = 1000 gr
        //превръщаме в грамове
        double quantityFood = Double.parseDouble(scanner.nextLine()) * 1000.00;
        double quantityHay = Double.parseDouble(scanner.nextLine()) * 1000.00; //сено
        double quantityCover = Double.parseDouble(scanner.nextLine()) * 1000.00;
        double guineaWeight = Double.parseDouble(scanner.nextLine()) * 1000.00;

        int countEveryTwoDays = 0;
        int countEveryThirdDays = 0;
        int monthDays = 0;
        boolean isThingsEnough = true;

        while (monthDays < 30) {

            monthDays++;
            countEveryTwoDays++;
            countEveryThirdDays++;

            quantityFood -= 300;
            if (quantityFood <= 0) {
                isThingsEnough = false;
                break;
            }

            if (countEveryTwoDays == 2) {

                double currentHay = quantityFood * 0.05;
                quantityHay -= currentHay;
                if (quantityHay <= 0) {
                    isThingsEnough = false;
                    break;
                }
                countEveryTwoDays = 0;
            }

            if (countEveryThirdDays == 3) {
                double currentCover = guineaWeight / 3.00;
                quantityCover -= currentCover;
                if (quantityCover <= 0) {
                    isThingsEnough = false;
                    break;
                }
                countEveryThirdDays = 0;
            }
        }
        if (!isThingsEnough) {
            System.out.print("Merry must go to the pet store!");
        } else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", quantityFood / 1000, quantityHay / 1000, quantityCover / 1000);
        }
    }
}
