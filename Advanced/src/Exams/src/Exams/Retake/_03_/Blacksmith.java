package Exams.Retake._03_;

import java.util.*;

public class Blacksmith {
    public static final int GLADIUS_RESOURCES = 70;
    public static final int SHAMSHIR_RESOURCES = 80;
    public static final int KATANA_RESOURCES = 90;
    public static final int SABRE_RESOURCES = 110;
    public static final String GLADIUS = "Gladius";
    public static final String SHAMSHIR = "Shamshir";
    public static final String KATANA = "Katana";
    public static final String SABRE = "Sabre";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> allSteels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(allSteels::offer);

        Deque<Integer> allCarbons = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(allCarbons::push);

        Map<String, Integer> swordCount = new TreeMap<>();

        while (!allSteels.isEmpty() && !allCarbons.isEmpty()) {

            int steel = allSteels.pop();
            int carbon = allCarbons.poll();

            int sum = steel + carbon;

            if (sum == GLADIUS_RESOURCES) {
                Integer currentCountSword = swordCount.get(GLADIUS);
                if (currentCountSword == null) {
                    currentCountSword = 0;
                }
                swordCount.put(GLADIUS, currentCountSword + 1);
            } else if (sum == SHAMSHIR_RESOURCES) {
                Integer currentCountSword = swordCount.get(SHAMSHIR);
                if (currentCountSword == null) {
                    currentCountSword = 0;
                }
                swordCount.put(SHAMSHIR, currentCountSword + 1);
            } else if (sum == KATANA_RESOURCES) {
                Integer currentCountSword = swordCount.get(KATANA);
                if (currentCountSword == null) {
                    currentCountSword = 0;
                }
                swordCount.put(KATANA, currentCountSword + 1);
            } else if (sum == SABRE_RESOURCES) {
                Integer currentCountSword = swordCount.get(SABRE);
                if (currentCountSword == null) {
                    currentCountSword = 0;
                }
                swordCount.put(SABRE, currentCountSword + 1);
            } else {
                carbon += 5;
                allCarbons.offerFirst(carbon);
            }
        }

        int forgedSword = swordCount.values().stream().mapToInt(Integer::intValue).sum();
        if (forgedSword != 0) {
            System.out.printf("You have forged %d swords.\n", forgedSword);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (allSteels.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            String leftSteels = String.join(", ", allSteels.toString());
            System.out.printf("Steel left: %s\n", leftSteels.replaceAll("[\\[\\]]", ""));
        }

        if (allCarbons.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            String leftCarbon = String.join(", ", allCarbons.toString());
            System.out.printf("Carbon left: %s\n", leftCarbon.replaceAll("[\\[\\]]", ""));
        }

        swordCount.forEach((sword, count) -> {
            System.out.printf("%s: %d\n", sword, count);
        });

    }
}
