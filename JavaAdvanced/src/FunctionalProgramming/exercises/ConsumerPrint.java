package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> print = s -> System.out.println(s);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(name -> print.accept(name));
    }
}
