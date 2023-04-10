package Exams.Mid.Exam_03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> journalList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Craft!".equals(input)) {

            String[] parts = input.split(" - ");
            String command = parts[0];
            String item = parts[1];

            switch (command) {
                case "Collect":
                    if (!journalList.contains(item)) {
                        journalList.add(item);
                    }
                    break;
                case "Drop":
                    journalList.remove(item);
                    break;
                case "Combine Items":
                    String[] items = item.split(":");
                    String oldItem = items[0];
                    String newItem = items[1];
                    if (journalList.contains(oldItem)) {
                        int index = journalList.indexOf(oldItem);
                        journalList.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (journalList.contains(item)) {
                        journalList.remove(item);
                        journalList.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        String output = journalList.toString().replaceAll("[\\[\\]]", "");
        System.out.print(String.join(", ", output));
    }
}
