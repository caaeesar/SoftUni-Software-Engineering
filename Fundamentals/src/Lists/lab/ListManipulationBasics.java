package Lists.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationBasics {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] splitLine = scanner.nextLine().split(" ");
        List<Integer> numbers = parseNumbers(splitLine);
        String command = scanner.nextLine();
        int number;
        int index;

        while (!"end".equals(command)) {
            String[] manipulation = command.split(" ");

            switch (manipulation[0]) {
                case "Add":
                    number = Integer.parseInt(manipulation[1]);
                    addElement(number,numbers);
                    break;
                case "Remove":
                    number = Integer.parseInt(manipulation[1]);
                    removeElement(number,numbers);
                    break;
                case "RemoveAt":
                    index = Integer.parseInt(manipulation[1]);
                    removeElementAtIndex(index,numbers);
                    break;
                case "Insert":
                    number = Integer.parseInt(manipulation[1]);
                    index = Integer.parseInt(manipulation[2]);
                    insertElement(number,index,numbers);
                    break;
            }
            command = scanner.nextLine();
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    private static void insertElement(int number, int index, List<Integer> numbers) {
        numbers.add(index,number);
    }

    private static void removeElementAtIndex(int index, List<Integer> numbers) {
        numbers.remove(index);
    }

    private static void removeElement(int number, List<Integer> numbers) {
        numbers.remove(Integer.valueOf(number));
    }

    private static void addElement(int number, List<Integer> numbers) {
        numbers.add(number);
    }

    static List<Integer> parseNumbers(String[] splitLine) {
        List<Integer> numbers = new ArrayList<>();
        for (String item : splitLine) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }
}
