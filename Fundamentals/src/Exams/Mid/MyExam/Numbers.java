package Exams.Mid.MyExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Finish".equals(input)) {
            String[] parts = input.split("\\s+");
            String command = parts[0];
            int value = Integer.parseInt(parts[1]);

            switch (command) {
                case "Add":
                    numbers.add(value);
                    break;
                case "Remove":
                    if (numbers.contains(value)) {
                        numbers.remove((Integer) value);
                    }
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(parts[2]);
                    if (numbers.contains(value)) {
                        int firstIndex = numbers.indexOf(value);
                        numbers.set(firstIndex, replacement);
                    }
                    break;
                case "Collapse":
                    int i = 0;
                    while (i < numbers.size()) {
                        Integer num = numbers.get(i);
                        if (num < value) {
                            numbers.remove((Integer) num);
                        } else {
                            i++;
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        numbers.forEach(num -> System.out.print(num + " "));
    }
}
