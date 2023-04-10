package ConditionalStatements.lab;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        boolean isEven = number % 2 == 0;

        if (isEven) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
