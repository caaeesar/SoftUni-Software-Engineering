package ConditionalStatements.lab;

import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1 = Integer.parseInt(scan.nextLine());
        int num2 = Integer.parseInt(scan.nextLine());

        // System.out.println(Math.max(num1,num2));

        if (num1 > num2) {
            System.out.println(num1);
        } else System.out.println(num2); // скрито условие (num1 <= num2)
    }
}
