package Exams.FinaleRetake.Exam_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> allFoodInfo = new ArrayList<>();

        String foodInfoRegex = "([#|])(?<itemName>[A-Za-z ]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(foodInfoRegex);
        Matcher matcher = pattern.matcher(input);

        int totalCalories = 0;

        while (matcher.find()) {

            String itemName = matcher.group("itemName");
            String expirationDate = matcher.group("date");
            int currentCalories = Integer.parseInt(matcher.group("calories"));

            totalCalories += currentCalories;
            String currentLine = String.format("Item: %s, Best before: %s, Nutrition: %d",
                    itemName, expirationDate, currentCalories);
            allFoodInfo.add(currentLine);
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!\n", days);
        allFoodInfo.forEach(System.out::println);
    }
}
