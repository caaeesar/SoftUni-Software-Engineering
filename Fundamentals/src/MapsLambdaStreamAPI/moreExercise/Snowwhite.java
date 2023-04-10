package MapsLambdaStreamAPI.moreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Snowwhite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // color        name,  physic
        Map<String, Map<String, Integer>> dwarfsDatabase = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!"Once upon a time".equals(command)) {

            String[] dwarfDate = command.split(" <:> ");
            String dwarfName = dwarfDate[0];
            String hatColor = dwarfDate[1];
            int physics = Integer.parseInt(dwarfDate[2]);

            Map<String, Integer> currentDwarfMap = dwarfsDatabase.get(hatColor);
            if (currentDwarfMap == null) {
                currentDwarfMap = new LinkedHashMap<>();
            }

            Integer currentPhysic = currentDwarfMap.get(dwarfName);
            if (currentPhysic == null) {
                currentPhysic = 0;
            }

            if (currentDwarfMap.containsKey(dwarfName)) {
                if (currentPhysic > physics) {
                    command = scanner.nextLine();
                    continue;
                }
            }
            currentDwarfMap.put(dwarfName, physics);
            dwarfsDatabase.put(hatColor, currentDwarfMap);
            command = scanner.nextLine();
        }

        //You must order the dwarfs by physics in descending order
        // and then by the total count of dwarfs with the same hat color in descending order.

        Map<String, Integer> map = new LinkedHashMap<>();

        for(Map.Entry<String, Map<String, Integer>> entry : dwarfsDatabase.entrySet()) {
            for(Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                map.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(), subEntry.getValue());
                 //       color[0]       + " " + name[1]         + " " + бр. на джуджетата[2] ,  physic
                //                               KEY                                             VALUE
            }
        }
        map.entrySet().stream().sorted((e2, e1) -> {
            int result = Integer.compare(e1.getValue(), e2.getValue());
            if (result == 0) {
                String[] parts1 = e1.getKey().split(" ");
                String[] parts2 = e2.getKey().split(" ");
                result = parts1[2].compareTo(parts2[2]);
            }
            return result;
        }).forEach(element -> {
            String[] parts = element.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d\n", parts[0], parts[1], element.getValue());
        });
    }
}
