package WhileLoop.exercise;

import java.util.Scanner;

public class Coins {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());

        //  1 лев = 100 стотинки
        // 0.5 * 100 = 50 единици
        //  монети -> 0,01ст., 0,02ст., 0,05ст., 0,10ст, 0,20ст., 0,50ст., 1лев, 2 лева
        //стотинки -> 1      ,   2    ,   5    ,  10   ,  20    ,  50    , 100  , 200

        double coins = Math.round(sum * 100); // превръщаме цялата сума в стотинки;
        // закръгляме, защото double има неточности
        int counter = 0;

        //започваме от най-голямата възможна сума, за да върнем възможно най-малко стотинки
        // използваме if-else конструкция
        while (coins != 0) {

            if (coins >= 200) {
                coins -= 200;

            } else if (coins >= 100) {
                coins -= 100;

            } else if (coins >= 50) {
                coins -= 50;

            } else if (coins >= 20) {
                coins -= 20;

            } else if (coins >= 10) {
                coins -= 10;

            } else if (coins >= 5) {
                coins -= 5;

            } else if (coins >= 2) {
                coins -= 2;

            } else if (coins >= 1) {
                coins -= 1;
            }
            ++counter;
        }
        System.out.print(counter);
    }
}
