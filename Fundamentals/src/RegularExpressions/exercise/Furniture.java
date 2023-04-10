package RegularExpressions.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>[0-9]+(\\.?[0-9]+))!(?<quantity>\\d+)\\b";
        Pattern pattern = Pattern.compile(regex);
        List<String> validFurniture = new ArrayList<>();
        double totalSpendMoney = 0.00;
        String command = scanner.nextLine();

        while (!"Purchase".equals(command)) {

            String information = command;
            Matcher matcher = pattern.matcher(information);

            if (matcher.find()) {
                validFurniture.add(matcher.group("name"));
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double currentPrice = price * quantity;
                totalSpendMoney += currentPrice;
            }
            command = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String furniture : validFurniture) {
            System.out.println(furniture);
        }
        System.out.printf("Total money spend: %.2f", totalSpendMoney);
    }
}
