package Lists.lab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class SumAdjacentEqualNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *
         *    List<BigDecimal> numbers = Arrays.stream(scanner.nextLine().split(" "))
         *            .map(BigDecimal::new)
         *            .collect(Collectors.toList());
         *
         *    int index = 1;
         *    while (index < numbers.size()) {
         *
         *        BigDecimal currentNum = numbers.get(index);
         *        BigDecimal previousNum = numbers.get(index - 1);
         *
         *        if (previousNum.compareTo(currentNum) == 0) {
         *            BigDecimal newNumber = previousNum.add(currentNum);
         *            numbers.set(index - 1, newNumber);
         *            numbers.remove(currentNum);
         *            index = 1;
         *        } else {
         *            index++;
         *        }
         *    }
         *    numbers.forEach(e -> System.out.print(new DecimalFormat("0.## ").format(e)));
         */

        String[] splitLine = scanner.nextLine().split(" ");
        List<Double> numbers = parseNumbers(splitLine);

        int index = 0;
        while (index < numbers.size() - 1) {

            double currentElement = numbers.get(index);
            double nextElement = numbers.get(index + 1);

            if (currentElement == nextElement) {
                double sum = currentElement + nextElement;
                numbers.set(index, sum);
                numbers.remove(index + 1);
                index = 0; // start from left to right
            } else {
                index++;
            }
        }
        for (double currentNumber : numbers) {
            System.out.print(new DecimalFormat("#.# ").format(currentNumber)); // форматиране
        }
    }

    static List<Double> parseNumbers(String[] splitLine) {
        List<Double> numbers = new ArrayList<>(splitLine.length);

        for (String item : splitLine) {
            numbers.add(Double.parseDouble(item));
        }
        return numbers;
    }
}
