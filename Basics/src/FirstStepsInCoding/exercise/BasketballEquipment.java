package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);

        int annualPay = Integer.parseInt(scan.nextLine());
        double sneakers = annualPay - (annualPay * 0.4);  //цената им е 40% по-малка от таксата за една година

        double equipment = sneakers - (sneakers * 0.2);
        double ball = equipment / 4;
        double accessories = ball / 5;

        double totalSum = annualPay + sneakers + equipment + ball + accessories;

        System.out.println(totalSum);
    }
}
