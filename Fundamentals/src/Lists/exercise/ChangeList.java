package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        String command = scanner.nextLine();
        String element;

        while (!"end".equals(command)) {
            String[] manipulation = command.split(" ");

            switch (manipulation[0]) {
                case "Delete":
                    element = manipulation[1];
                    removeElements(numbers, element);
                    break;
                case "Insert":
                    element = manipulation[1];
                    int position = Integer.parseInt(manipulation[2]);
                    addElement(element, position, numbers);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.print(String.join(" ", numbers));
    }

    private static void addElement(String element, int position, List<String> numbers) {
        numbers.add(position, element);
    }

    private static void removeElements(List<String> numbers, String element) {
        int index = 0;
        while (index < numbers.size()) {
            if (numbers.get(index).equals(element)) {
                numbers.remove(index);
            } else {
                index++;
            }
        }
    }
}
