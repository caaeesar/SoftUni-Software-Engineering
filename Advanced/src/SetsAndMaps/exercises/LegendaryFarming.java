package SetsAndMaps.exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//fixme 60/100
public class LegendaryFarming {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junkMaterials = new TreeMap<>();

        boolean isWinRace = false;
        String regex = "(?<quantity>\\d+) (?<material>[A-Za-z]+)";
        Pattern pattern = Pattern.compile(regex);
        String winnerMaterials = "";

        while (!isWinRace) {

            Matcher matcher = pattern.matcher(scanner.nextLine());

            while (matcher.find()) {
                int quantity = Integer.parseInt(matcher.group("quantity"));
                String material = matcher.group("material").toLowerCase();

                if ("shards".equals(material) || "fragments".equals(material) || "motes".equals(material)) {
                    quantity += keyMaterials.get(material);
                    if (quantity >= 250) {
                        quantity -= 250;
                        isWinRace = true;
                        winnerMaterials = material;
                    }
                    keyMaterials.put(material, quantity);
                } else {
                    Integer currentJunkQuantity = junkMaterials.get(material);
                    if (currentJunkQuantity == null) {
                        currentJunkQuantity = 0;
                    }
                    junkMaterials.put(material, currentJunkQuantity + quantity);
                }
                if (isWinRace) {
                    break;
                }
            }
        }
        String winnerItem = "";
        switch (winnerMaterials) {
            case "shards":
                winnerItem = "Shadowmourne";
                break;
            case "fragments":
                winnerItem = "Valanyr";
                break;
            case "motes":
                winnerItem = "Dragonwrath";
                break;
        }

        System.out.printf("%s obtained!\n", winnerItem);
        keyMaterials
                .entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
                .forEach(m -> System.out.printf("%s: %d\n", m.getKey(), m.getValue()));

        junkMaterials.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }
}