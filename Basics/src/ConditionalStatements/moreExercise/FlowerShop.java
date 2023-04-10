package ConditionalStatements.moreExercise;

import java.util.Scanner;

public class FlowerShop {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        int magnolias = Integer.parseInt(scan.nextLine());
        int hyacinths = Integer.parseInt(scan.nextLine()); //зюмбюли
        int roses = Integer.parseInt(scan.nextLine());
        int cacti = Integer.parseInt(scan.nextLine());
        double giftPrice = Double.parseDouble(scan.nextLine());

        double totalBill = ((magnolias * 3.25) + (hyacinths * 4) + (roses * 3.50) + (cacti * 8));
        double tax = totalBill * 0.05;
        double bill = totalBill - tax;

        boolean isEnough = bill >= giftPrice;
        if (isEnough) {
            double leftMoney = Math.floor(bill - giftPrice);
            System.out.printf("She is left with %.0f leva.",leftMoney);
        } else {
            double needMoney = Math.ceil(giftPrice - bill);
            System.out.printf("She will have to borrow %.0f leva.",needMoney);
        }
    }
}
