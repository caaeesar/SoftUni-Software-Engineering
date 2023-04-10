package Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
/*
1 2 3 4 3 4 5
4 1
 */

        /*
         *  List<Integer> sequenceOfNumber = Arrays.stream(scanner.nextLine().split(" "))
         *                 .map(Integer::parseInt)
         *                 .collect(Collectors.toList());
         *
         *         int specialBombNumber = Integer.parseInt(scanner.next());
         *         int power = Integer.parseInt(scanner.next());
         *
         *         while (sequenceOfNumber.contains(specialBombNumber)) {
         *
         *             int bombIndex = sequenceOfNumber.indexOf(specialBombNumber);
         *
         *             int leftBound = Math.max(0, bombIndex - power);
         *             int rightBound = Math.min(sequenceOfNumber.size() - 1, bombIndex + power);
         *
         *             for (int index = rightBound; index >= leftBound; index--) {
         *                 sequenceOfNumber.remove(index);
         *             }
         *         }
         *         int sum = sequenceOfNumber.stream().mapToInt(Integer::intValue)
         *                 .sum();
         *         System.out.print(sum);
         */

        String[] splitLine = scanner.nextLine().split(" ");
        List<Integer> numbers = parseNumbers(splitLine);
        int bomb = scanner.nextInt();
        int power = scanner.nextInt();

        if (!numbers.contains(bomb)) {
            printSum(numbers);
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {

            int initialSpecialIndex;
            int currentNumber = numbers.get(i);

            if (currentNumber == bomb) {
                initialSpecialIndex = i;
                removeLeftIndex(numbers, power, initialSpecialIndex);
                int newSpecialIndex = findSpecialIndex(numbers, bomb);
                removeRightIndex(numbers, power, newSpecialIndex);
                numbers.remove(newSpecialIndex);
                i = 0;
            }
        }
        printSum(numbers);
    }

    private static void printSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    private static int findSpecialIndex(List<Integer> numbers, int bomb) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bomb) {
                return i;
            }
        }
        return -1;
    }

    private static void removeRightIndex(List<Integer> numbers, int power, int specialIndex) {
        int countElement = 0;
        for (int i = specialIndex; i < numbers.size() - 1; i++) { // махаме специалното число от размера
            countElement++;
        }
        if (power > countElement) {
            power = countElement;
        }
        while (power != 0) {
            numbers.remove(specialIndex + 1);
            power--;
        }
    }

    private static void removeLeftIndex(List<Integer> numbers, int power, int specialIndex) {
        int countElement = 0;
        for (int i = 0; i < specialIndex; i++) {
            countElement++;
        }
        if (power > countElement) {
            power = countElement;
        }
        while (power != 0) {
            numbers.remove(specialIndex - 1);
            power--;
            specialIndex--;
        }
    }

    static List<Integer> parseNumbers(String[] splitLine) {
        List<Integer> numbers = new ArrayList<>();
        for (String item : splitLine) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }
}
