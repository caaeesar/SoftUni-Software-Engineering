package MapsLambdaStreamAPI.exercise;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *  Map<String, Integer> junkMaterials = new LinkedHashMap<>();
         *         Map<String, Integer> keyMaterials = new LinkedHashMap<>();
         *         keyMaterials.put("shards", 0);
         *         keyMaterials.put("fragments", 0);
         *         keyMaterials.put("motes", 0);
         *         boolean isWinGame = false;
         *
         *         while (!isWinGame) {
         *
         *             String[] currentLine = scanner.nextLine().split("\\s");
         *             for (int index = 0; index < currentLine.length; index += 2) {
         *
         *                 int quantity = Integer.parseInt(currentLine[index]);
         *                 String material = currentLine[index + 1].toLowerCase();
         *
         *                 switch (material) {
         *                     // key materials
         *                     case "shards":
         *                     case "fragments":
         *                     case "motes":
         *                         Integer currentKeyQuantity = keyMaterials.get(material);
         *                         keyMaterials.put(material, currentKeyQuantity + quantity);
         *                         if (keyMaterials.get(material) >= 250) {
         *                             isWinGame = true;
         *                         }
         *                         break;
         *                     // junk materials
         *                     default:
         *                         Integer currentJunkQuantity = junkMaterials.get(material);
         *                         if (currentJunkQuantity == null) {
         *                             currentJunkQuantity = 0;
         *                         }
         *                         junkMaterials.put(material, currentJunkQuantity + quantity);
         *                         break;
         *                 }
         *                 if (isWinGame) {
         *                     break;
         *                 }
         *             }
         *         }
         *         String legendaryItem = "";
         *         String bestMaterial = "";
         *         if (isWinGame) {
         *             for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
         *                 int x = Integer.compare(entry.getValue(), 250);
         *                 if (x == 0 || x > 0) {
         *                     bestMaterial = entry.getKey();
         *                     switch (bestMaterial) {
         *                         case "shards":
         *                             legendaryItem = "Shadowmourne";
         *                             break;
         *                         case "fragments":
         *                             legendaryItem = "Valanyr";
         *                             break;
         *                         case "motes":
         *                             legendaryItem = "Dragonwrath";
         *                             break;
         *                     }
         *                     System.out.printf("%s obtained!\n", legendaryItem);
         *                 }
         *             }
         *         }
         *         keyMaterials.put(bestMaterial, keyMaterials.get(bestMaterial) - 250);
         *         for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
         *             System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
         *         }
         *         for (Map.Entry<String, Integer> entry : junkMaterials.entrySet()) {
         *             System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
         *         }
         */
        Map<String, Integer> keyMaterialQuantity = new LinkedHashMap<>();
        keyMaterialQuantity.put("shards", 0);
        keyMaterialQuantity.put("fragments", 0);
        keyMaterialQuantity.put("motes", 0);
        Map<String, Integer> junkMaterialQuantity = new LinkedHashMap<>();
        boolean isWinRace = false;
        String winLegendaryMaterial = "";
        String material = "";
        int quantity = 0;

        while (!isWinRace) {
            String[] input = scanner.nextLine().split(" ");

            for (int index = 0; index < input.length; index++) {

                boolean isReadPairInput = false;

                if (index % 2 != 0) { // материал
                    material = input[index].toLowerCase();
                    isReadPairInput = true;
                } else { // количество
                    quantity = Integer.parseInt(input[index]);
                }

                if (isReadPairInput) {

                    switch (material) {
                        case "shards":
                        case "fragments":
                        case "motes":

                            if (keyMaterialQuantity.get(material) == 0) {
                                keyMaterialQuantity.put(material, quantity);
                            } else {
                                keyMaterialQuantity.put(material, keyMaterialQuantity.get(material) + quantity);
                            }
                            break;
                        default:

                            if (!junkMaterialQuantity.containsKey(material)) {
                                junkMaterialQuantity.put(material, quantity);
                            } else {
                                junkMaterialQuantity.put(material, junkMaterialQuantity.get(material) + quantity);
                            }
                            break;
                    }

                    for (Map.Entry<String, Integer> entry : keyMaterialQuantity.entrySet()) {
                        int result = Integer.compare(entry.getValue(), 250);

                        if (result > 0 || result == 0) {
                            isWinRace = true;
                            winLegendaryMaterial = entry.getKey();
                        }
                    }
                }
                if (isWinRace) {
                    break;
                }
            }
        }

        String legendaryItem = "";
        switch (winLegendaryMaterial) {
            case "shards":
                legendaryItem = "Shadowmourne";
                break;
            case "fragments":
                legendaryItem = "Valanyr";
                break;
            case "motes":
                legendaryItem = "Dragonwrath";
                break;
        }
        System.out.printf("%s obtained!%n", legendaryItem);
        keyMaterialQuantity.put(winLegendaryMaterial, Math.abs(keyMaterialQuantity.get(winLegendaryMaterial) - 250));

        for (Map.Entry<String, Integer> entry : keyMaterialQuantity.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : junkMaterialQuantity.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
