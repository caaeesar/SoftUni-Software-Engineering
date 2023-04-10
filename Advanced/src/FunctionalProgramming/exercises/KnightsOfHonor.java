package FunctionalProgramming.exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printWithSir = s -> System.out.printf("Sir %s\n",s);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(name -> printWithSir.accept(name));
    }
}
