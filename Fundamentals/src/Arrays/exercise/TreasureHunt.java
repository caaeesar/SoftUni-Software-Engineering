package Arrays.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> lootItems = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\|")));
        String input = scanner.nextLine();

        while (!"Yohoho!".equals(input)) {

            List<String> command = new ArrayList<>(Arrays.asList(input.split(" ")));

            switch (command.get(0)) {

                case "Loot":
                    looting(lootItems, command);
                    break;
                case "Drop":
                    int index = Integer.parseInt(command.get(1));
                    if (lootItems.size() > index && index >= 0) {
                        dropping(lootItems, index);
                    }
                    break;
                case "Steal":
                    int stealElements = Integer.parseInt(command.get(1));
                    if (stealElements > lootItems.size()) {
                        stealElements = lootItems.size();
                    }
                    stealing(lootItems, stealElements);
                    break;
            }
            input = scanner.nextLine();
        }
        if (lootItems.isEmpty()) {
            System.out.print("Failed treasure hunt.");
        } else {
            double sum = 0.00;
            for (String item : lootItems) {
                sum += item.length();
            }
            double averageGain = sum / lootItems.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }

    private static void stealing(List<String> lootItems, int stealElements) {
        int size = lootItems.size();
        int removedIndex = size - stealElements;
        while (stealElements != 0) {
            if (stealElements == 1) {
                System.out.printf("%s", lootItems.remove(removedIndex));
            } else {
                System.out.printf("%s, ", lootItems.remove(removedIndex));
            }
            stealElements--;
        }
        System.out.println();
    }

    private static void dropping(List<String> lootItems, int index) {
        String item = lootItems.get(index);
        lootItems.remove(item);
        lootItems.add(item);
    }

    private static void looting(List<String> lootItems, List<String> currentLootItems) {
        for (int i = 1; i < currentLootItems.size(); i++) {

            if (!lootItems.contains(currentLootItems.get(i))) {
                lootItems.add(0, currentLootItems.get(i));
            }
        }
    }
}
