package RegularExpressions.exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int nLines = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= nLines; currentLine++) {

            String encryptedMessage = scanner.nextLine();

            String regexKeyLetters = "[SsTtAaRr]";
            // Pattern pattern = Pattern.compile("[STAR]", Pattern.CASE_INSENSITIVE);
            Pattern pattern = Pattern.compile(regexKeyLetters);
            Matcher matcherKeyLetters = pattern.matcher(encryptedMessage);
            long decryptionKey = matcherKeyLetters.results().count();

            StringBuilder decryptedMessage = new StringBuilder();
            for (int position = 0; position < encryptedMessage.length(); position++) {
                char symbol = encryptedMessage.charAt(position);
                char newSymbol = (char) (symbol - decryptionKey);
                decryptedMessage.append(newSymbol);
            }

            String regexValidMessage = "([^-@!:>])*@(?<planetName>[A-Za-z]+)([^-@!:>])*:(?<population>\\d+)([^-@!:>])*!(?<attackType>A|D)!([^-@!:>])*->(?<soldierCount>\\d+)([^-@!:>])*";
            pattern = Pattern.compile(regexValidMessage);
            Matcher matcher = pattern.matcher(decryptedMessage);
            while (matcher.find()) {

                String planetName = matcher.group("planetName");
                // int population = Integer.parseInt(matcher.group("population"));
                char attackType = matcher.group("attackType").charAt(0);
                //  int soldierCount = Integer.parseInt(matcher.group("soldierCount"));

                switch (attackType) {
                    case 'A':
                        attackedPlanets.add(planetName);
                        break;
                    case 'D':
                        destroyedPlanets.add(planetName);
                        break;
                }
            }
        }
        System.out.printf("Attacked planets: %d\n", attackedPlanets.size());
        attackedPlanets.stream().sorted(Comparator.naturalOrder()).forEach(p -> System.out.printf("-> %s\n", p));
        System.out.printf("Destroyed planets: %d\n", destroyedPlanets.size());
        destroyedPlanets.stream().sorted(Comparator.naturalOrder()).forEach(p -> System.out.printf("-> %s\n", p));
    }
}
