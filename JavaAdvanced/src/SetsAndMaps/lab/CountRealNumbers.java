package SetsAndMaps.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> map = new LinkedHashMap<>();

        for (double currentNumber : numbers) {

            Integer count = map.get(currentNumber);
            if (count == null) {
                count = 0;
            }
            map.put(currentNumber, count + 1);

        }
        map.forEach((number, count) -> {
            System.out.printf("%.1f -> %d\n", number, count);
        });
    }
}
