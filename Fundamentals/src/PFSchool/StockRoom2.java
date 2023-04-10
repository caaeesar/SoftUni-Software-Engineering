package PFSchool;

import java.util.Scanner;

public class StockRoom2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] products = scanner.nextLine().split(" ");
        String[] secondLine = scanner.nextLine().split(" "); // реалната дължина
        String[] thirdLine = scanner.nextLine().split(" ");

        long[] quantity = new long[products.length]; // Ако в масива няма индекс, който отговаря на името, трябва да се приеме количество 0;
        double[] price = new double[thirdLine.length];

        for (int index = 0; index < secondLine.length; index++) {

            quantity[index] = Long.parseLong(secondLine[index]);
        }

        for (int index = 0; index < thirdLine.length; index++) {

            price[index] = Double.parseDouble(thirdLine[index]);
        }

        String command = scanner.next();

        while (!"done".equals(command)) {

            String currentProduct = command;
            long currentQuantity = scanner.nextLong();

            for (int index = 0; index < products.length; index++) {

                if (currentProduct.equals(products[index])) {

                    if (currentQuantity <= quantity[index]) {

                        double currentPrice = currentQuantity * price[index];
                        System.out.printf("%s x %d costs %.2f%n", currentProduct, currentQuantity, currentPrice);
                        quantity[index] -= currentQuantity;
                    } else {
                        System.out.printf("We do not have enough %s", currentProduct);
                    }
                }
            }
            command = scanner.next();
        }
    }
}
