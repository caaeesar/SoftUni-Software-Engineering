package Exams.Final.Exam_01;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> plantsRarities = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRatings = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("<->");
            String plant = parts[0];
            double rarity = Double.parseDouble(parts[1]);
            plantsRarities.put(plant, rarity);
            plantsRatings.put(plant, new ArrayList<>());
        }

        String input = scanner.nextLine();
        while (!"Exhibition".equals(input)) {

          /*  input = input.replace(" - ", ": ");
            String[] tokens = input.split(": ");*/
            String[] tokens = input.split("[-:\\s]+");

            String command = tokens[0];
            String plant = tokens[1];

            if (!plantsRarities.containsKey(plant)) {
                System.out.println("error");
                input = scanner.nextLine();
                continue;
            }

            List<Double> currentRatingList = plantsRatings.get(plant);
            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(tokens[2]);
                    currentRatingList.add(rating);
                    plantsRatings.put(plant, currentRatingList);
                    break;

                case "Update":
                    double rarity = Double.parseDouble(tokens[2]);
                    plantsRarities.put(plant, rarity);
                    break;
                case "Reset":
                   // plantsRatings.put(plant, new ArrayList<>());
                    currentRatingList.clear();
                    break;
            }
            input = scanner.nextLine();
        }
        Map<String, Double> averageRating = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : plantsRatings.entrySet()) {

            String plant = entry.getKey();
            double ratingSum = 0.00;

            List<Double> currentRantingList = entry.getValue();
            double average = 0.00;

            if (currentRantingList.size() != 0) {
                for (Double rating : currentRantingList) {
                    ratingSum += rating;
                }
                if (ratingSum != 0) {
                    average = ratingSum / currentRantingList.size();
                }
            }
            averageRating.put(plant, average);
        }

        Map<String, List<Double>> outputMap = new LinkedHashMap<>();

        for (Map.Entry<String, Double> entry : plantsRarities.entrySet()) {

            String plant = entry.getKey();
            List<Double> currentPlantInfo = outputMap.get(plant);
            if (currentPlantInfo == null) {
                currentPlantInfo = new ArrayList<>();
            }
            currentPlantInfo.add(0, entry.getValue());
            outputMap.put(plant, currentPlantInfo);
        }

        for (Map.Entry<String, Double> entry : averageRating.entrySet()) {

            String plant = entry.getKey();
            List<Double> currentPlantInfo = outputMap.get(plant);
            currentPlantInfo.add(1, entry.getValue());
            outputMap.put(plant, currentPlantInfo);
        }
        System.out.println("Plants for the exhibition:");
        outputMap.forEach((key, value) -> {

            System.out.printf("- %s; Rarity: %.0f; Rating: %.2f\n",
                    key, value.get(0), value.get(1));

        });
    }
}
