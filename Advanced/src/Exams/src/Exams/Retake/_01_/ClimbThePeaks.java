package Exams.Retake._01_;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> allPeaks = new ArrayDeque<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        // remove peaks if is conquered !!
        Map<String, Integer> mountainPeaksDifficulty = new LinkedHashMap<>();
        mountainPeaksDifficulty.put("Vihren", 80);
        mountainPeaksDifficulty.put("Kutelo", 90);
        mountainPeaksDifficulty.put("Banski Suhodol", 100);
        mountainPeaksDifficulty.put("Polezhan", 60);
        mountainPeaksDifficulty.put("Kamenitza", 70);

        List<String> conqueredPeaks = new LinkedList<>();

        // stack
        Deque<Integer> foodPortions = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(foodPortions::push);

        // queue
        Deque<Integer> stamina = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stamina::offer);

        while (!allPeaks.isEmpty() && !foodPortions.isEmpty() && !stamina.isEmpty()) {
            String currentPeak = allPeaks.getFirst();
            int currentLevel = mountainPeaksDifficulty.get(currentPeak);

            int dailyFood = foodPortions.pop();
            int dailyStamina = stamina.poll();

            int bothQuantities = dailyFood + dailyStamina;

            if (bothQuantities >= currentLevel) {
                mountainPeaksDifficulty.remove(currentPeak);
                conqueredPeaks.add(currentPeak);
                allPeaks.removeFirst();
            }
        }
        if (allPeaks.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!conqueredPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String peak : conqueredPeaks) {
                System.out.println(peak);
            }
        }
    }
}
