package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int commands = Integer.parseInt(scanner.nextLine());
        List<String> guests = new ArrayList<>();
        String name;

        for (int i = 0; i < commands; i++) {

            String[] input = scanner.nextLine().split(" ");
            name = input[0];

            switch (input[2]) {
                case "going!":
                    addPerson(guests, name);
                    break;
                case "not":
                    removePerson(guests, name);
                    break;
            }
        }
        for (String currentName : guests) {
            System.out.println(currentName);
        }
    }

    private static void removePerson(List<String> guests, String name) {
        if (!guests.contains(name)) {
            System.out.printf("%s is not in the list!%n", name);
        } else {
            guests.remove(name);
        }
    }

    private static void addPerson(List<String> guests, String name) {
        if (guests.contains(name)) {
            System.out.printf("%s is already in the list!%n", name);
        } else {
            guests.add(name);
        }
    }
}
