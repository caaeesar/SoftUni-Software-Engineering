package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> isFirstLetterUpper = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> print = s -> System.out.println(s);

        List<String> words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(str -> isFirstLetterUpper.test(str))
                .collect(Collectors.toList());

        System.out.println(words.size());
        words.stream().forEach(s -> print.accept(s));

    }
}
