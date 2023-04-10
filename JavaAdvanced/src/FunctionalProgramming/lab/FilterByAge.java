package FunctionalProgramming.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> peopleAges = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] data = scanner.nextLine().split(",\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            peopleAges.putIfAbsent(name, age);

        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filter = filterByConditionAge(condition, age);
        Consumer<Map.Entry<String, Integer>> formatted = formatting(format);

        peopleAges
                .entrySet()
                .stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> formatted.accept(entry));

    }

    private static Consumer<Map.Entry<String, Integer>> formatting(String format) {
        switch (format) {
            case "name age":
                return e -> System.out.printf("%s - %d\n", e.getKey(), e.getValue());
            case "name":
                return e -> System.out.printf("%s\n", e.getKey());
            case "age":
                return e -> System.out.printf("%s\n", e.getValue());
        }
        return null;
    }

    private static Predicate<Integer> filterByConditionAge(String condition, int age) {
        return condition.equals("older") ? (x -> x >= age) : (x -> x <= age);
    }
}


