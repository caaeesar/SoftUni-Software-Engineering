package SetsAndMaps.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> venueStatistics = new LinkedHashMap<>();

        String regex = "(?<singer>([A-Za-z]+) ?([A-Za-z]+)? ?([A-Za-z]+)?) @(?<venue>([A-Za-z]+) ?([A-Za-z]+)? ?([A-Za-z]+)?) (?<price>[0-9]+) (?<count>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        while (!"End".equals(input)) {

            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));

                int amount = price * count;

                Map<String, Integer> singerMoney = venueStatistics.get(venue);
                if (singerMoney == null) {
                    singerMoney = new LinkedHashMap<>();
                }

                Integer totalAmount = singerMoney.get(singer);
                if (totalAmount == null) {
                    totalAmount = 0;
                }

                singerMoney.put(singer, totalAmount + amount);
                venueStatistics.put(venue, singerMoney);
            }
            input = scanner.nextLine();
        }
        venueStatistics
                .forEach((key, value) -> {
                    System.out.println(key);
                    value.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                            .forEach(nestedEntry -> System.out.printf("#  %s -> %d\n", nestedEntry.getKey(), nestedEntry.getValue()));
                });
    }
}
