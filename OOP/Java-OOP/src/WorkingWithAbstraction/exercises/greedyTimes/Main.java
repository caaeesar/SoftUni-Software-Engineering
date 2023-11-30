package WorkingWithAbstraction.exercises.greedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] pairs = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(capacity);

        for (int i = 0; i < pairs.length; i += 2) {

            String item = pairs[i];
            long quantity = Long.parseLong(pairs[i + 1]);

            if (item.length() == 3) { // cash different type
                bag.addCash(item, quantity);
            } else if (item.toLowerCase().endsWith("gem")) { //gems different type
                bag.addGems(item, quantity);
            } else if (item.equalsIgnoreCase("gold")) { // gold only one item
                bag.addGold(quantity);
            }
        }
        bag.showBagContent();
    }
}