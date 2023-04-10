package MapsLambdaStreamAPI.lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *  Map<Double, Integer> numbersOfOccurrences = new TreeMap<>();
         *
         *         double[] numbers = Arrays.stream(scanner.nextLine().split("\\s"))
         *                 .mapToDouble(Double::parseDouble)
         *                 .toArray();
         *
         *         for (double currentNum : numbers) {
         *
         *             Integer currentValue = numbersOfOccurrences.get(currentNum);
         *             // null - специална стойност, което ни показва, в паметта не сочим към никакъв обект
         *             // няма присвоена стойност
         *             if (currentValue == null) {
         *                 currentValue = 0;
         *             }
         *             numbersOfOccurrences.put(currentNum, currentValue + 1);
         *         }
         *         for (Map.Entry<Double, Integer> entry : numbersOfOccurrences.entrySet()) {
         *             System.out.printf("%s -> %d\n", new DecimalFormat("#.##").format(entry.getKey()), entry.getValue());
         *         }
         */

        double[] numbers = Arrays.stream
                (scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> counts = new TreeMap<>();

        for (Double currentNumber : numbers) {

            Integer currentCount = counts.get(currentNumber);
            if (counts.containsKey(currentNumber)) {
                counts.put(currentNumber, currentCount + 1);
            } else {
                counts.put(currentNumber, 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######"); // %s placeholder for decimal !!
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
