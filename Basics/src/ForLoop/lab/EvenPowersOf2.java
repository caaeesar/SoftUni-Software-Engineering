package ForLoop.lab;

import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= input; i += 2 ) {
           double power = Math.pow(2,i);
           System.out.printf("%.0f%n",power);
        }
    }
}
