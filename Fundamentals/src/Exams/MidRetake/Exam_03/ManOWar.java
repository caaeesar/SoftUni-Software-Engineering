package Exams.MidRetake.Exam_03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> warship = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Retire".equals(input)) {
            String[] parts = input.split(" ");
            String command = parts[0];
            int index;
            int damage;

            switch (command) {
                case "Fire":
                    index = Integer.parseInt(parts[1]);
                    damage = Integer.parseInt(parts[2]);

                    if (index >= 0 && index < warship.size()) {
                        int sectionHealth = warship.get(index);
                        sectionHealth -= damage;

                        if (sectionHealth <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                        warship.set(index, sectionHealth);
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(parts[1]);
                    int endIndex = Integer.parseInt(parts[2]);
                    damage = Integer.parseInt(parts[3]);

                    if ((startIndex >= 0 && startIndex < pirateShip.size()) &&
                            (endIndex >= 0 && endIndex < pirateShip.size())) {

                        for (int defendIndex = startIndex; defendIndex <= endIndex; defendIndex++) {
                            int sectionHealth = pirateShip.get(defendIndex);
                            sectionHealth -= damage;

                            if (sectionHealth <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                            pirateShip.set(defendIndex, sectionHealth);
                        }
                    }
                    break;
                case "Repair":
                    index = Integer.parseInt(parts[1]);
                    int health = Integer.parseInt(parts[2]);
                    if (index >= 0 && index < pirateShip.size()) {
                        int sectionHealth = pirateShip.get(index);
                        if (sectionHealth + health >= maxHealthCapacity) {
                            sectionHealth = maxHealthCapacity;
                        } else {
                            sectionHealth += health;
                        }
                        pirateShip.set(index, sectionHealth);
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int currentSection : pirateShip) {
                        if (currentSection < (maxHealthCapacity * 0.2)) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.\n", count);
                    break;
            }
            input = scanner.nextLine();
        }

        int pirateShipSum = 0;
        for (int section : pirateShip) {
            pirateShipSum += section;
        }
        System.out.printf("Pirate ship status: %d\n", pirateShipSum);

        int warshipSum = 0;
        for (int section : warship) {
            warshipSum += section;
        }
        System.out.printf("Warship status: %d\n", warshipSum);
    }
}
