package RegularExpressions.lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

       /* String regex = "\\b([0-9]{2})([-\\./])([A-Z][a-z]{2})\\2([0-9]{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            String day = matcher.group(1);
            String month = matcher.group(3);
            String year = matcher.group(4);
            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        } */


         /* capturing group can be assigned
        an explicit name by using the syntax
        (?<name>X) where X is the usual regular expression.
        */

        String regex = "\\b(?<day>\\d{2})([-\\./])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");
            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }
    }
}
