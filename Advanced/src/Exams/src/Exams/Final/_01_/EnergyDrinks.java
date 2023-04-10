package Exams.Final._01_;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks {

    public static final int MAX_CAFFEINE = 300;

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> milligramsOfCaffeine = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(milligramsOfCaffeine::push);

        Deque<Integer> energyDrinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().trim().split(", "))
                .map(Integer::parseInt)
                .forEach(energyDrinks::offer);

        int hisCaffeine = 0;

        while (milligramsOfCaffeine.size() > 0 && energyDrinks.size() > 0) {

            int currentCaffeine = milligramsOfCaffeine.pop();
            int currentDrink = energyDrinks.peek();

            int calculatedMg = currentCaffeine * currentDrink;

            if ((hisCaffeine + calculatedMg) <= MAX_CAFFEINE) {
                hisCaffeine += calculatedMg;
                energyDrinks.poll();
            } else {
                hisCaffeine -= 30;
                if (hisCaffeine < 0) {
                    hisCaffeine = 0;
                }
                energyDrinks.poll();
                energyDrinks.offerLast(currentDrink);
            }
        }

        if (energyDrinks.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            String[] leftDrink = new String[energyDrinks.size()];
            for (int i = 0; i < leftDrink.length; i++) {
                leftDrink[i] = String.valueOf(energyDrinks.poll());
            }
            System.out.printf("Drinks left: %s\n", String.join(", ", leftDrink));

        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", hisCaffeine);
    }
}
