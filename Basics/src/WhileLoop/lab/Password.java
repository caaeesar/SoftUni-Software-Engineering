package WhileLoop.lab;

import java.util.Scanner;

public class Password {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String correctPass = scanner.nextLine();
        String currentPass = scanner.nextLine();

        while (!currentPass.equals(correctPass)) {
            currentPass = scanner.nextLine();
        }
        System.out.println("Welcome " + name + "!");

      /*  while (true) {

            if (!currentPass.equals(correctPass)){
            currentPass = scanner.nextLine();
            }

            if (currentPass.equals(correctPass)) {
            System.out.println("Welcome " + name + "!");
            break;
            }
        } */
    }
}
