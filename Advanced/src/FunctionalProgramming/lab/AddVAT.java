package FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> parse = num -> Double.parseDouble(num);
        UnaryOperator<Double> addVAT = num -> num * 1.20;
        Consumer<Double> print = e -> System.out.printf("%.2f\n", e);

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(n -> parse.apply(n))
                .map(n -> addVAT.apply(n))
                .forEach(e -> print.accept(e));
    }
}
