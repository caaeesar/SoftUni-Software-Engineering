package Exams.Final._02_;

import java.util.*;

public class ChocolateTime {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> chocolateCount = new TreeMap<>();
        chocolateCount.put("Milk Chocolate", 0); // 30
        chocolateCount.put("Dark Chocolate", 0); // 50
        chocolateCount.put("Baking Chocolate", 0); // 100


        Deque<Double> milk = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .forEach(milk::offer);

        Deque<Double> cacao = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .forEach(cacao::push);

        int milkCount = 0;
        int darkCount = 0;
        int bakingCount = 0;

        while (!milk.isEmpty() && !cacao.isEmpty()) {

            double currentMilk = milk.poll();
            double currentCacao = cacao.pop();
            double mix = currentCacao / (currentMilk + currentCacao);
            double currentPercentage = mix * 100;

            if (currentPercentage == 30.00) {
                milkCount++;
                Integer count = chocolateCount.get("Milk Chocolate");
                chocolateCount.put("Milk Chocolate", count + 1);
            } else if (currentPercentage == 50.00) {
                darkCount++;
                Integer count = chocolateCount.get("Dark Chocolate");
                chocolateCount.put("Dark Chocolate", count + 1);
            } else if (currentPercentage == 100.00) {
                bakingCount++;
                Integer count = chocolateCount.get("Baking Chocolate");
                chocolateCount.put("Baking Chocolate", count + 1);
            } else {
                currentMilk += 10;
                milk.offerLast(currentMilk);
            }
        }

        if (milkCount >= 1 && darkCount >= 1 && bakingCount >= 1) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolateCount.entrySet().stream().filter(e -> e.getValue() > 0).forEach(e -> System.out.printf("# %s --> %d\n", e.getKey(), e.getValue()));
    }
}
