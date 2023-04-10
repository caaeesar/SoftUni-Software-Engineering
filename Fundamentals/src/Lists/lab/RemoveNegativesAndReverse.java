package Lists.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] splitLine = scanner.nextLine().split(" ");
        List<Integer> numbers = parseNumbers(splitLine);

        numbers.removeIf(n -> n < 0);

       /* int index = 0;
        while (numbers.size() > index) {

            if (numbers.get(index) < 0) {
                numbers.remove(index);
            } else {
                index++;
            }
        }*/

        Collections.reverse(numbers);

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        }
    }

    private static List<Integer> parseNumbers(String[] splitLine) {
        List<Integer> numbers = new ArrayList<>();
        for (String item : splitLine) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }
}
