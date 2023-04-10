package Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] splitLine = scanner.nextLine().split(" ");
        List<Integer> wagons = parseNumbers(splitLine);
        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] input = command.split(" ");
            switch (input[0]) {
                case "Add":
                    int wagon = Integer.parseInt(input[1]);
                    addNewWagon(wagons, wagon);
                    break;
                default:
                    int passengers = Integer.parseInt(input[0]);
                    seatedPassengers(wagons, capacity, passengers);
                    break;
            }
            command = scanner.nextLine();
        }
        for (int currentWagon : wagons) {
            System.out.print(currentWagon + " ");
        }
    }

    private static void seatedPassengers(List<Integer> wagons, int capacity, int passengers) {
        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i) + passengers <= capacity) {
                wagons.set(i, wagons.get(i) + passengers);
                break;
            }
        }
    }

    private static void addNewWagon(List<Integer> wagons, int wagon) {
        wagons.add(wagon);
    }

    private static List<Integer> parseNumbers(String[] splitLine) {
        List<Integer> wagons = new ArrayList<>(splitLine.length);
        for (String item : splitLine) {
            wagons.add(Integer.parseInt(item));
        }
        return wagons;
    }
}
