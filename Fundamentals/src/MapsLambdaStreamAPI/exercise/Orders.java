package MapsLambdaStreamAPI.exercise;

import java.util.*;

public class Orders {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();
        Map<String, Double> productPrice = new LinkedHashMap<>();
        List<String> productsList = new ArrayList<>();

        while (!"buy".equals(command)) {
            String[] information = command.split(" ");
            String productName = information[0];
            Double currentPrice = Double.parseDouble(information[1]);
            Integer currentQuantity = Integer.parseInt(information[2]);

            if (!productsList.contains(productName)) { // if product doesn't exist
                productsList.add(productName);
                productQuantity.put(productName, currentQuantity); // add it with its starting quantity
                productPrice.put(productName, currentPrice);
            } else { // if product already exist
                Double previousPrice = productPrice.get(productName);
                int result = Double.compare(previousPrice, currentPrice);
                if (result != 0) {
                    productPrice.put(productName, currentPrice); // replace with the new price
                }
                int increaseQuantity = productQuantity.get(productName) + currentQuantity;
                productQuantity.put(productName, increaseQuantity);
            }
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productPrice.entrySet()) {

            int quantity = productQuantity.get(entry.getKey());
            double totalPrice = entry.getValue() * quantity;

            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }
    }
}
