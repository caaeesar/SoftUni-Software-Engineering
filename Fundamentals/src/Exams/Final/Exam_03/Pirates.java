package Exams.Final.Exam_03;

import java.util.*;

public class Pirates {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> targetedSettlements = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Sail".equals(input)) {

            String[] settlementsInfo = input.split("\\|\\|");
            String town = settlementsInfo[0];
            int population = Integer.parseInt(settlementsInfo[1]);
            int gold = Integer.parseInt(settlementsInfo[2]);

            List<Integer> currentInfo = targetedSettlements.get(town);

            if (currentInfo == null) {
                currentInfo = new ArrayList<>();
                currentInfo.add(0, population);
                currentInfo.add(1, gold);
            } else {
                int currentPopulation = currentInfo.get(0);
                int currentGold = currentInfo.get(1);
                population += currentPopulation;
                gold += currentGold;
                currentInfo.set(0,population);
                currentInfo.set(1,gold);
            }
            targetedSettlements.put(town, currentInfo);
            input = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!"End".equals(command)) {

            String[] parts = command.split("=>");
            String event = parts[0];
            String town = parts[1];
            int people;
            int gold;

            List<Integer> currentInfo = targetedSettlements.get(town);
            int totalPopulation = currentInfo.get(0);
            int totalGold = currentInfo.get(1);

            switch (event) {
                case "Plunder":
                    people = Integer.parseInt(parts[2]);
                    gold = Integer.parseInt(parts[3]);

                    totalPopulation -= people;
                    totalGold -= gold;
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", town, gold, people);

                    if ((totalPopulation <= 0) || (totalGold <= 0)) {
                        targetedSettlements.remove(town);
                        System.out.printf("%s has been wiped off the map!\n", town);
                        command = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(parts[2]);
                    if (gold <= 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        command = scanner.nextLine();
                        continue;
                    } else {
                        totalGold += gold;
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",
                                gold, town, totalGold);
                    }
                    break;
            }
            currentInfo = new ArrayList<>();
            currentInfo.add(0, totalPopulation);
            currentInfo.add(1, totalGold);
            targetedSettlements.put(town, currentInfo);
            command = scanner.nextLine();
        }
        if (targetedSettlements.size() != 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", targetedSettlements.size());
            targetedSettlements.forEach((town, info) -> {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",
                        town, info.get(0), info.get(1));
            });
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}

