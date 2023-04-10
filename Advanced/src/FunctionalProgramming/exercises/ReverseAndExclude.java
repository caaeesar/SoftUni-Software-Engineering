package FunctionalProgramming.exercises;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> collection = Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(collection);

        // collection.removeIf(e -> e % n == 0);

        Predicate<Integer> filter = e -> e % n != 0;

        collection
                .stream()
                .filter(e -> filter.test(e))
                .forEach(e -> System.out.print(e + " "));
    }
}
