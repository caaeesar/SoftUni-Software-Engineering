package MapsLambdaStreamAPI.lab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] arguments) {

        //  Arrays.stream(new Scanner(System.in).nextLine().split("\\s"))
        //                .filter(w -> w.length() % 2 == 0).forEach(w -> System.out.println(w));

        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Arrays.stream(words).filter(w -> w.length() % 2 == 0).forEach(System.out::println);
    }
}
