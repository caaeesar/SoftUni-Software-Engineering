package RegularExpressions.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> demonsNameList = Arrays.stream(scanner.nextLine()
                        .split(","))
                .collect(Collectors.toList());


        for (String currentDemonName : demonsNameList) {

            currentDemonName = currentDemonName.replaceAll("\\s", "");

            int health = 0;
            String regex = "[^\\d-+*/.]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcherCharacter = pattern.matcher(currentDemonName);
            while (matcherCharacter.find()) {
                char asciiCode = matcherCharacter.group().charAt(0);
                health += asciiCode;
            }

            double damage = 0.00;
            regex = "(?<sign>[-+])?(?<number>\\d+(\\.\\d+)?)";
            pattern = Pattern.compile(regex);
            Matcher matcherDigit = pattern.matcher(currentDemonName);
            while (matcherDigit.find()) {
                double number = Double.parseDouble(matcherDigit.group("number"));
                if (matcherDigit.group("sign") != null) {
                    String sign = matcherDigit.group("sign");
                    switch (sign) {
                        case "-":
                            damage -= number;
                            break;
                        case "+":
                            damage += number;
                            break;
                    }
                } else {
                    damage += number;
                }
            }
            regex = "[\\*\\/]";
            pattern = Pattern.compile(regex);
            Matcher matcherOperator = pattern.matcher(currentDemonName);
            while (matcherOperator.find()) {
                String operator = matcherOperator.group();
                switch (operator) {
                    case "*":
                        damage *= 2;
                        break;
                    case "/":
                        damage /= 2;
                        break;
                }
            }
            System.out.printf("%s - %d health, %.2f damage\n",
                    currentDemonName, health, damage);
        }

     /*   List<String> demonsNames = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",\\s*")));

        for (String demon : demonsNames) {
            demon = demon.replaceAll("\\s", "");

            Pattern patternHealth = Pattern.compile("[^\\/\\+\\*\\.\\d-]");
            Matcher matcherHealth = patternHealth.matcher(demon);

            int health = 0;
            while (matcherHealth.find()) {
                char symbol = matcherHealth.group().charAt(0);
                health += symbol;
            }

            Pattern patternDamage = Pattern.compile("(?<operator>[\\+\\-]?)(?<digit>\\d+([\\.]\\d+)?)");
            Matcher matcherDamage = patternDamage.matcher(demon);

            double baseDamage = 0.00;
            while (matcherDamage.find()) {
                double number = Double.parseDouble(matcherDamage.group("digit"));
                String operator = matcherDamage.group("operator");
                switch (operator) {
                    case "-":
                        baseDamage -= number;
                        break;
                    default:
                        baseDamage += number;
                        break;
                }
            }
            double damage = getTotalDamage(baseDamage, demon);

            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }
    }

    static double getTotalDamage(double baseDamage, String demonName) {

        for (int index = 0; index < demonName.length(); index++) {

            char symbol = demonName.charAt(index);
            switch (symbol) {
                case '/':
                    baseDamage /= 2;
                    break;
                case '*':
                    baseDamage *= 2;
                    break;
            }
        }
        return baseDamage;
    }*/
    }
}
