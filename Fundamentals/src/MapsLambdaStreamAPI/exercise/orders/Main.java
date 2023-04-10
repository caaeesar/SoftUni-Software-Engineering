package MapsLambdaStreamAPI.exercise.orders;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Product> productMap = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!"buy".equals(command)) {

            String[] productInformation = command.split("\\s");
            String productName = productInformation[0];
            double price = Double.parseDouble(productInformation[1]);
            int quantity = Integer.parseInt(productInformation[2]);

            if (!productMap.containsKey(productName)) {
                Product newProduct = new Product(productName, price, quantity);
                productMap.put(productName, newProduct);
            } else {
                Product existProduct = productMap.get(productName);
                existProduct.setQuantity(quantity);
                double currentPrice = existProduct.getPrice();
                if (price != currentPrice) {
                    existProduct.setPrice(price);
                }
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
