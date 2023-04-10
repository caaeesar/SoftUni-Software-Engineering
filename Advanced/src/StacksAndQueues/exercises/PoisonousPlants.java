package StacksAndQueues.exercises;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allPlants = Integer.parseInt(scanner.nextLine());

        // compare pesticide values from right to left => using stack
        Deque<Integer> currentPlants = new ArrayDeque<>(allPlants);
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(currentPlants::push);

        Deque<Integer> dailySurvivePlants = new ArrayDeque<>();

        int days = 0;
        int dailyDied = 0;

        while (true) {

            for (int i = 0; i < allPlants - 1; i++) {

                int rightPlant = currentPlants.pop();
                int leftPlant = currentPlants.peek();

                if (rightPlant <= leftPlant) {
                    dailySurvivePlants.push(rightPlant);
                } else {
                    dailyDied++;
                }
            }

            dailySurvivePlants.push(currentPlants.pop()); // count first element or the last in stack
            if (dailyDied == 0) {
                break;
            }
            dailySurvivePlants.forEach(currentPlants::push);// reverse
            allPlants = currentPlants.size();
            dailySurvivePlants.clear();
            dailyDied = 0;
            days++;
        }
        System.out.println(days);
    }
}
