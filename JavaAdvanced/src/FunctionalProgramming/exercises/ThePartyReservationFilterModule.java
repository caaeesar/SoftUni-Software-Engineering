package FunctionalProgramming.exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String input = scanner.nextLine();
        while (!"Print".equals(input)) {

            String command = input.split(";")[0];
            String type = input.split(";")[1];
            String parameter = input.split(";")[2];
            String currentFilter = type + ";" + parameter;

            switch (command) {
                case "Add filter":
                    filters.add(currentFilter);
                    break;
                case "Remove filter":
                    filters.remove(currentFilter);
                    break;
            }
            input = scanner.nextLine();
        }

        Iterator<String> iterator = filters.iterator();
        while (iterator.hasNext()) {
            String filter = iterator.next();
            String type = filter.split(";")[0];
            String parameter = filter.split(";")[1];

            switch (type) {
                case "Starts with":
                    people.removeIf(p -> p.startsWith(parameter));
                    break;
                case "Ends with":
                    people.removeIf(p -> p.endsWith(parameter));
                    break;
                case "Length":
                    people = people
                            .stream()
                            .filter(p -> p.length() == Integer.parseInt(parameter))
                            .collect(Collectors.toList());
                    break;
                case "Contains":
                    people.removeIf(p -> p.contains(parameter));
                   break;
            }
        }
        people.forEach(p -> System.out.print(p + " "));
    }
}
