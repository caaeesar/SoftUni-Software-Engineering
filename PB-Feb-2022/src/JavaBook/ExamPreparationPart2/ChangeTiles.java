package JavaBook.ExamPreparationPart2;

import java.util.Scanner;

public class ChangeTiles {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double savedMoney = Double.parseDouble(scanner.nextLine());
        double wight = Double.parseDouble(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double side = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double priceBrick = Double.parseDouble(scanner.nextLine());
        double priceWork = Double.parseDouble(scanner.nextLine());

        double floorArea = length * wight;
        double brickArea = (side * height) / 2;
        double needBricks = Math.ceil(floorArea / brickArea) + 5;
        double totalPrice = (needBricks * priceBrick) + priceWork;

        if (savedMoney >= totalPrice) {
            System.out.printf("%.2f lv left.", savedMoney - totalPrice);
        } else {
            System.out.printf("You'll need %.2f lv more.", totalPrice - savedMoney);
        }
    }
}
