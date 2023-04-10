package OtherProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortList {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = parseNumbers(scanner.nextLine());
        // Collections.sort(numbers); във възходящ ред
        // Collections.reverse(numbers); към низходяш ред

        List<Integer> sorted = new ArrayList<>();

        while (!numbers.isEmpty()) {
            int min = numbers.get(0);
            int minIndex = 0;

            for (int index = 1; index < numbers.size(); index++) {
                int currentNumber = numbers.get(index);

                if (currentNumber < min) {
                    min = currentNumber;
                    minIndex = index;
                }
            }
            sorted.add(min);
            numbers.remove(minIndex);

           // numbers.remove(Integer.valueOf(min));
           // sorted.add(numbers.remove(minIndex));
        }
        for (int currentNum : sorted) {
            System.out.printf("%d ", currentNum);
        }
    }

    static List<Integer> parseNumbers(String line) {
        String[] splitLine = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String item : splitLine) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }
}
/*
4 8 5 2 7 9
2 4 5 7 8 9
 */
