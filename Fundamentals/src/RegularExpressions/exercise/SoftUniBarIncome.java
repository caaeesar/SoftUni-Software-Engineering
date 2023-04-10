package RegularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double totalIncome = 0.00;
        String input = scanner.nextLine().trim();
        while (!"end of shift".equals(input)) {

            String regex = "^%(?<customer>[A-Z][a-z]+)%[^\\|\\$\\%\\.]*<(?<product>\\w+)>[^\\|\\$\\%\\.]*\\|(?<count>\\d+)\\|[^\\d+\\|\\$\\%\\.]*(?<price>\\d+\\.?\\d+)\\$$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {

                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double currentTotalPrice = count * price;
                totalIncome += currentTotalPrice;

                System.out.printf("%s: %s - %.2f\n", customer, product, currentTotalPrice);
            }
            input = scanner.nextLine().trim();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
