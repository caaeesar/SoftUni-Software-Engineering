package Exams.Final.MyExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "[@#]+(?<color>[a-z]{3,})[@#]+[^a-zA-Z0-9]*\\/+(?<amount>[0-9]+)\\/+";
        Pattern eggPattern = Pattern.compile(regex);
        Matcher eggMatcher = eggPattern.matcher(input);

        while (eggMatcher.find()) {
            String color = eggMatcher.group("color");
            String amount = eggMatcher.group("amount");
            System.out.printf("You found %s %s eggs!\n", amount, color);
        }
    }
}
