package Lists.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         *
         *         List<Integer> newList = new ArrayList<>(numbers.length / 2);
         *
         *         for (int index = 0; index < numbers.length / 2; index++) {
         *
         *             int var1 = numbers[index];
         *             int var2 = numbers[numbers.length - 1 - index];
         *             int sum = var1 + var2;
         *             newList.add(sum);
         *         }
         *         if (numbers.length % 2 != 0) {
         *             newList.add(numbers[numbers.length / 2]);
         *         }
         *         newList.forEach(e -> System.out.print(e + " "));
         */

        String[] splitLine = scanner.nextLine().split(" ");
        List<Integer> numbers = parseNumbers(splitLine);
        int size = numbers.size();

        for (int currentIndex = 0; currentIndex < size / 2; currentIndex++) {

            int lastIndex = size - 1 - currentIndex;
            int currentElement = numbers.get(currentIndex);
            int lastElement = numbers.get(lastIndex);
            int sum = currentElement + lastElement;

            numbers.set(currentIndex, sum);
            numbers.remove(lastIndex);
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    static List<Integer> parseNumbers(String[] splitLine) {
        List<Integer> numbers = new ArrayList<>(splitLine.length);
        for (String item : splitLine) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }
}
