package JavaBook;

import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two integers:");
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());

        if (num1 > num2) {
            System.out.printf("Greater number: %d", num1);
        } else {
            System.out.printf("Greater number: %d", num2);
        }
    }
}
