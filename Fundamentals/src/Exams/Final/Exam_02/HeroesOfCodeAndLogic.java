package Exams.Final.Exam_02;

import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> map = new LinkedHashMap<>();

        int nLines = Integer.parseInt(scanner.nextLine());
        for (int currentLine = 1; currentLine <= nLines; currentLine++) {

            String[] parts = scanner.nextLine().split(" ");
            String heroName = parts[0];
            int HP = Integer.parseInt(parts[1]);
            int MP = Integer.parseInt(parts[2]);

            List<Integer> currentInfo = new ArrayList<>();
            currentInfo.add(0, HP);
            currentInfo.add(1, MP);
            map.putIfAbsent(heroName, currentInfo);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {

            String[] gameInfo = input.split(" - ");
            String action = gameInfo[0];
            String heroName = gameInfo[1];
            int amount;
            List<Integer> currentHeroInfo = map.get(heroName);
            int HP = currentHeroInfo.get(0);
            int MP = currentHeroInfo.get(1);
            int recoveredAmount;

            switch (action) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(gameInfo[2]);
                    String spellName = gameInfo[3];

                    if (MP >= neededMP) {
                        MP -= neededMP;
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",
                                heroName, spellName, MP);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n",
                                heroName, spellName);
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(gameInfo[2]);
                    String attacker = gameInfo[3];
                    HP -= damage;

                    if (HP > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",
                                heroName, damage, attacker, HP);
                    } else {
                        System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                        map.remove(heroName);
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Recharge":
                    amount = Integer.parseInt(gameInfo[2]);
                    if (MP + amount > 200) {
                        recoveredAmount = 200 - MP;
                        MP = 200;
                    } else {
                        MP += amount;
                        recoveredAmount = amount;
                    }
                    System.out.printf("%s recharged for %d MP!\n", heroName, recoveredAmount);
                    break;
                case "Heal":
                    amount = Integer.parseInt(gameInfo[2]);
                    if (HP + amount > 100) {
                        recoveredAmount = 100 - HP;
                        HP = 100;
                    } else {
                        HP += amount;
                        recoveredAmount = amount;
                    }
                    System.out.printf("%s healed for %d HP!\n", heroName, recoveredAmount);
                    break;
            }
            currentHeroInfo = new ArrayList<>();
            currentHeroInfo.add(0, HP);
            currentHeroInfo.add(1, MP);
            map.put(heroName, currentHeroInfo);
            input = scanner.nextLine();
        }

        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.printf("  HP: %d\n", value.get(0));
            System.out.printf("  MP: %d\n", value.get(1));

        });
    }
}
