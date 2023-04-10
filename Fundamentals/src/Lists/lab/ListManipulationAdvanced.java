package Lists.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] splitLine = scanner.nextLine().split(" ");
        List<Integer> numbers = parseNumbers(splitLine);
        String command = scanner.nextLine();
        int number;

        while (!"end".equals(command)) {

            String[] manipulation = command.split(" ");
            switch (manipulation[0]) {
                case "Contains":
                    number = Integer.parseInt(manipulation[1]);
                    boolean isContains = containElement(number, numbers);
                    if (isContains) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String oddOrEven = manipulation[1];
                    printOddEvenElement(oddOrEven, numbers);
                    break;
                case "Get":
                    getSum(numbers);
                    break;
                case "Filter":
                    String condition = manipulation[1];
                    number = Integer.parseInt(manipulation[2]);
                    filterElement(condition, numbers, number);
                    break;
            }
            command = scanner.nextLine();
        }
    }

    static void filterElement(String condition, List<Integer> numbers, int number) {
        for (int currentNumber : numbers) {
            switch (condition) {
                case "<":
                    if (currentNumber < number) {
                        System.out.print(currentNumber + " ");
                    }
                    break;
                case ">":
                    if (currentNumber > number) {
                        System.out.print(currentNumber + " ");
                    }
                    break;
                case ">=":
                    if (currentNumber >= number) {
                        System.out.print(currentNumber + " ");
                    }
                    break;
                case "<=":
                    if (currentNumber <= number) {
                        System.out.print(currentNumber + " ");
                    }
                    break;
            }
        }
        System.out.println();
    }

    static void getSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    static void printOddEvenElement(String oddOrEven, List<Integer> numbers) {
        switch (oddOrEven) {
            case "even":
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 == 0) {
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                break;
            case "odd":
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) % 2 != 0) {
                        System.out.print(numbers.get(i) + " ");
                    }
                }
                break;
        }
        System.out.println();
    }

    static boolean containElement(int number, List<Integer> numbers) {
        return numbers.contains(number);
    }

    static List<Integer> parseNumbers(String[] splitLine) {
        List<Integer> numbers = new ArrayList<>();
        for (String item : splitLine) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }
}
