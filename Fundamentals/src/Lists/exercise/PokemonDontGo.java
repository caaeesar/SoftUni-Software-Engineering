package Lists.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonDontGo {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] splitLine = scanner.nextLine().split(" ");
        List<Integer> numbers = parseNumbers(splitLine);
        int sum = 0;
        while (!numbers.isEmpty()) {
            int currentIndex = Integer.parseInt(scanner.nextLine());
            int currentElement;

            if (currentIndex < 0) {
                currentElement = numbers.get(0);
                numbers.set(0, numbers.get(numbers.size() - 1));
                increasingAndDecreasingElement(numbers, currentElement);
            } else if (currentIndex > numbers.size() - 1) {
                currentElement = numbers.get(numbers.size() - 1);
                numbers.set(numbers.size() - 1, numbers.get(0));
                increasingAndDecreasingElement(numbers, currentElement);
            } else {
                currentElement = numbers.get(currentIndex);
                numbers.remove(currentIndex);
                increasingAndDecreasingElement(numbers, currentElement);
            }
            sum += currentElement;
        }
        System.out.print(sum);
    }

    private static void increasingAndDecreasingElement(List<Integer> numbers, int currentElement) {

        for (int index = 0; index < numbers.size(); index++) {

            if (numbers.get(index) <= currentElement) {
                numbers.set(index, numbers.get(index) + currentElement);
            } else {
                numbers.set(index, numbers.get(index) - currentElement);
            }
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
