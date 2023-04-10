package myExam;

import java.util.*;

public class _01_ {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textiles = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(textiles::offer);


        Deque<Integer> medicaments = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(medicaments::push);

        Map<String, Integer> itemCount = new TreeMap<>(); // todo descending order
        itemCount.put("Patch", 0);
        itemCount.put("Bandage", 0);
        itemCount.put("MedKit", 0);

      /*  boolean isHaveRemain = false;
        int remainResources = 0;*/

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {

            int currentTextile = textiles.poll();
            int currentMedicament = medicaments.pop();

            /*if (isHaveRemain) {
                currentMedicament += remainResources;
                remainResources = 0;
                isHaveRemain = false;
            }*/

            int combineElements = currentTextile + currentMedicament;

            if (combineElements == 30) {
                int currentPatchCount = itemCount.get("Patch");
                itemCount.put("Patch", currentPatchCount + 1);
            } else if (combineElements == 40) {
                int currentBandageCount = itemCount.get("Bandage");
                itemCount.put("Bandage", currentBandageCount + 1);
            } else if (combineElements == 100) {
                int currentMedKitCount = itemCount.get("MedKit");
                itemCount.put("MedKit", currentMedKitCount + 1);
            } else {

                if (combineElements > 100) { // todo =
                    int remainResources = combineElements - 100;
                    if (medicaments.size() >= 1) {
                        int nextMedicament = medicaments.pop();
                        nextMedicament += remainResources;
                        medicaments.push(nextMedicament);
                    }
                    // isHaveRemain = true;
                    int currentMedKitCount = itemCount.get("MedKit");
                    itemCount.put("MedKit", currentMedKitCount + 1);
                } else {
                    currentMedicament += 10;
                    medicaments.push(currentMedicament);
                }

            }
        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else {

            if (textiles.isEmpty()) {
                System.out.println("Textiles are empty.");
            }
            if (medicaments.isEmpty()) {
                System.out.println("Medicaments are empty.");
            }
        }

        itemCount.entrySet().stream().filter(i -> i.getValue() != 0).sorted((i1, i2) -> {
            int sort = Integer.compare(i2.getValue(), i1.getValue());
            if (sort == 0) {
                sort = i1.getKey().compareTo(i2.getKey());
            }
            return sort;
        }).forEach(i -> {
            System.out.printf("%s - %d\n", i.getKey(), i.getValue());
        });


        if (!medicaments.isEmpty()) {
            String[] leftMedicaments = new String[medicaments.size()];
            for (int i = 0; i < leftMedicaments.length; i++) {
                leftMedicaments[i] = String.valueOf(medicaments.pop());
            }
            System.out.printf("Medicaments left: %s", String.join(", ", leftMedicaments));
        }

        if (!textiles.isEmpty()) {
            String[] leftTextiles = new String[textiles.size()];
            for (int i = 0; i < leftTextiles.length; i++) {
                leftTextiles[i] = String.valueOf(textiles.poll());
            }
            System.out.printf("Textiles left: %s", String.join(", ", leftTextiles));
        }

    }
}
