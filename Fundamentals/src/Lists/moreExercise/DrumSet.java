package Lists.moreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrumSet {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String line = scanner.nextLine();
        List<Integer> initialDrumQuality = parseNumbers(line);
        List<Integer> currentDrumQuality = new ArrayList<>(initialDrumQuality);
        String command = scanner.nextLine();

        while (!"Hit it again, Gabsy!".equals(command)) {
            int hitPower = Integer.parseInt(command);

            for (int index = 0; index < currentDrumQuality.size(); index++) {
                int currentDrum = currentDrumQuality.get(index) - hitPower;
                double drumPrice = initialDrumQuality.get(index) * 3;

                if (currentDrum <= 0) {

                    if (budget > 0 && budget >= drumPrice) {
                        int newDrum = initialDrumQuality.get(index);
                        currentDrumQuality.set(index, newDrum);
                        budget -= drumPrice;
                    } else {
                        currentDrumQuality.remove(index);
                        initialDrumQuality.remove(index);
                        index--;
                    }
                } else {
                    currentDrumQuality.set(index, currentDrum);
                }
            }
            command = scanner.nextLine();
        }
        for (int quality : currentDrumQuality) {
            System.out.print(quality + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", budget);
    }

    private static List<Integer> parseNumbers(String line) {
        String[] splitLine = line.split(" ");
        List<Integer> initialDrumQuality = new ArrayList<>();
        for (String quality : splitLine) {
            initialDrumQuality.add(Integer.valueOf(quality));
        }
        return initialDrumQuality;
    }
}
