package PFSchool;

import java.util.Scanner;

public class StockRoom {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] products = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" ");
        String[] thirdLine = scanner.nextLine().split(" ");

        long[] quantity = new long[secondLine.length];
        double[] price = new double[thirdLine.length];

        for (int index = 0; index < secondLine.length; index++) {

            quantity[index] = Long.parseLong(secondLine[index]);
        }

        for (int index = 0; index < secondLine.length; index++) {

            price[index] = Double.parseDouble(thirdLine[index]);
        }

        String command = scanner.nextLine();

        while (!"Done".equals(command)) {

            String currentProduct = command;

            for (int index = 0; index < products.length; index++) {

                if (currentProduct.equals(products[index])) {

                    System.out.printf("%s costs: %.2f; Available quantity: %d%n", products[index], price[index], quantity[index]);

                }
            }
            command = scanner.nextLine();
        }
    }
}
