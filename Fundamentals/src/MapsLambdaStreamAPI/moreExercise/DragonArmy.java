package MapsLambdaStreamAPI.moreExercise;

import java.util.*;

public class DragonArmy {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        //  type        name    stats: damage, health, and armor
        Map<String, Map<String, List<Integer>>> dragonsDateMap = new LinkedHashMap<>();
        // Type is preserved as in the input order -> main map LinkedHashMap
        // but dragons are sorted alphabetically by name -> nested map - TreeHashMap

        int totalLines = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= totalLines; currentLine++) {

            String[] dragonInformation = scanner.nextLine().split(" ");
            String type = dragonInformation[0];
            String name = dragonInformation[1];
            //Default values are as follows: health 250, damage 45, and armor 10.
            // Missing stat will be marked by null
            int damage = dragonInformation[2].equals("null") ? 45 : Integer.parseInt(dragonInformation[2]);
            int health = dragonInformation[3].equals("null") ? 250 : Integer.parseInt(dragonInformation[3]);
            int armor = dragonInformation[4].equals("null") ? 10 : Integer.parseInt(dragonInformation[4]);

            Map<String, List<Integer>> currentNameStatistic = dragonsDateMap.get(type);
            // няма такъв тип дракон
            if (currentNameStatistic == null) {
                currentNameStatistic = new TreeMap<>();
            }

            List<Integer> currentStats = currentNameStatistic.get(name);
            if (currentStats == null) {
                currentStats = new ArrayList<>();
            }

            //If the same dragon is added a second time, the new stats should overwrite the previous ones.
            // Two dragons are considered equal if they match by both name and type.
            boolean isHaveSameDragon = false;
            // ако вече съществува такъв тип дракон (проверяваме дали има някакво съвпадение по име)
            for (String currentName : currentNameStatistic.keySet()) {
                if (currentName.equals(name)) {
                    isHaveSameDragon = true;
                    break;
                }
            }
            if (isHaveSameDragon) {
                currentStats = new ArrayList<>();
            }
            currentStats.add(damage);
            currentStats.add(health);
            currentStats.add(armor);
            currentNameStatistic.put(name, currentStats);
            dragonsDateMap.put(type, currentNameStatistic);
        }

        dragonsDateMap.forEach((key, value) -> {
            double totalDamage = 0.00;
            double totalHealth = 0.00;
            double totalArmor = 0.00;
            for (List<Integer> statsList : value.values()) {
                totalDamage += statsList.get(0);
                totalHealth += statsList.get(1);
                totalArmor += statsList.get(2);
            }
            double averageDamage = totalDamage / value.size();
            double averageHealth = totalHealth / value.size();
            double averageArmor = totalArmor / value.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", key, averageDamage, averageHealth, averageArmor);
            dragonsDateMap.get(key).forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                    k, v.get(0), v.get(1), v.get(2)));
        });
    }
}