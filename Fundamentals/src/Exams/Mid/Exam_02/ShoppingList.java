package Exams.Mid.Exam_02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!"))
                .map(String::valueOf)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Go Shopping!".equals(input)) {

            String[] parts = input.split(" ");
            String command = parts[0];
            String item = parts[1];

            switch (command) {
                case "Urgent":
                    if (!shoppingList.contains(item)) {
                        addItem(shoppingList, item);
                    }
                    break;
                case "Unnecessary":
                    if (shoppingList.contains(item)) {
                        removeItem(shoppingList, item);
                    }
                    break;
                case "Correct":
                    String oldItem = parts[1];
                    String newItem = parts[2];
                    if (shoppingList.contains(oldItem)) {
                        changeItemName(shoppingList, oldItem, newItem);
                    }
                    break;
                case "Rearrange":
                    if (shoppingList.contains(item)) {
                        removeAndAdd(shoppingList, item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        String result = shoppingList.toString();
        result = result.replaceAll("[\\[\\]]", ""); // replace
        System.out.print(String.join(", ", result));
    }

    private static void removeAndAdd(List<String> shoppingList, String item) {
        shoppingList.remove(item);
        shoppingList.add(item);
    }

    private static void changeItemName(List<String> shoppingList, String oldItem, String newItem) {
        int indexOfOldElement = shoppingList.indexOf(oldItem);
        shoppingList.set(indexOfOldElement, newItem);
    }

    private static void removeItem(List<String> shoppingList, String item) {
        shoppingList.remove(item);
    }

    private static void addItem(List<String> shoppingList, String item) {
        shoppingList.add(0, item);
    }
}
