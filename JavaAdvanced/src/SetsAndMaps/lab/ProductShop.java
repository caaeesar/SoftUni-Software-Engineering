package SetsAndMaps.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> foodShop = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {

            String[] information = input.split(", ");
            String shop = information[0];
            String product = information[1];
            double price = Double.parseDouble(information[2]);

            Map<String, Double> productsPrice = foodShop.get(shop);
            if (productsPrice == null) {
                productsPrice = new LinkedHashMap<>();
            }
            productsPrice.put(product, price);
            foodShop.put(shop, productsPrice);

            input = scanner.nextLine();
        }
        foodShop.forEach((shop, data) -> {
            System.out.println(shop + "->");
            data.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f\n", product, price);
            });
        });
    }
}
