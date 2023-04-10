package FirstStepsInCoding.lab;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);

        double squareMetres = Double.parseDouble(scan.nextLine());
        double price = 7.61;
        double totalSum = squareMetres * price;
        double discount = totalSum * 0.18;   // 18% по условие ни е отстъпката
        // => за да я превърнем в число, делим на 100

        double sumWithDiscount = totalSum - discount;

        System.out.printf("The final price is: %.2f lv.%n", sumWithDiscount);
        System.out.printf("The discount is: %.2f lv.", discount);
    }
}
