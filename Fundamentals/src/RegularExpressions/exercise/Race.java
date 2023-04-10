package RegularExpressions.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] participantsList = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .toArray(String[]::new);

        Map<String, Integer> racersDistance = new LinkedHashMap<>();

        for (String currentParticipant : participantsList) {
            racersDistance.put(currentParticipant, 0);
        }

        String input = scanner.nextLine();
        while (!"end of race".equals(input)) {

              /*for (int index = 0; index < hiddenInformation.length(); index++) {
                char symbol = hiddenInformation.charAt(index);

                if (Character.isAlphabetic(symbol)) {
                    name.append(symbol);
                } else if (Character.isDigit(symbol)) {
                    distance += Integer.parseInt(symbol + "");
                }
            }*/

            StringBuilder currentName = new StringBuilder();
            List<Integer> currentDigits = new ArrayList<>();

            String regexLetter = "[A-Za-z]";
            Pattern pattern = Pattern.compile(regexLetter);
            Matcher matcherLetter = pattern.matcher(input);
            while (matcherLetter.find()) {
                currentName.append(matcherLetter.group());
            }

            String regexDigit = "\\d";
            pattern = Pattern.compile(regexDigit);
            Matcher matcherDigit = pattern.matcher(input);
            while (matcherDigit.find()) {
                currentDigits.add(Integer.valueOf(matcherDigit.group()));
            }

            int distance = currentDigits.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            Integer currentDistance = racersDistance.get(currentName.toString());
            if (racersDistance.containsKey(currentName.toString())) {
                if (currentDistance == 0) {
                    racersDistance.put(currentName.toString(), distance);
                } else {
                    racersDistance.put(currentName.toString(), currentDistance + distance);
                }
            }

            input = scanner.nextLine();
        }
        List<String> bestRacersList = racersDistance.entrySet()
                .stream()
                .sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.printf("1st place: %s\n" +
                        "2nd place: %s\n" +
                        "3rd place: %s",
                bestRacersList.get(0),
                bestRacersList.get(1),
                bestRacersList.get(2));
    }
}
