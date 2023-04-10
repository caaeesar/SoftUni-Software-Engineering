package Exams.MidRetake.MyRetakeExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PaintingsNumbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
//todo 85/100
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"END".equals(input)) {

            String[] parts = input.split(" ");
            String command = parts[0];
            int currentNumber;
            int index;
            switch (command) {
                case "Change":
                    currentNumber = Integer.parseInt(parts[1]);
                    int newNumber = Integer.parseInt(parts[2]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == currentNumber) {
                            numbers.set(i, newNumber);
                        }
                    }
                    break;
                case "Hide":
                    currentNumber = Integer.parseInt(parts[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == currentNumber) {
                            numbers.remove(Integer.valueOf(currentNumber));
                        }
                    }
                    break;
                case "Switch":
                    int num1 = Integer.parseInt(parts[1]);
                    int num2 = Integer.parseInt(parts[2]);
                    boolean isFirstNumExist = false;
                    boolean isSecondNumExist = false;
                    int index1 = -1;
                    int index2 = -1;
                    for (int i = 0; i < numbers.size(); i++) {
                        Integer number = numbers.get(i);
                        if (number == num1) {
                            isFirstNumExist = true;
                            index1 = i;
                        }
                        if (number == num2) {
                            isSecondNumExist = true;
                            index2 = i;
                        }
                    }
                    if (isFirstNumExist && isSecondNumExist) {
                        numbers.set(index1, num2);
                        numbers.set(index2, num1);
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(parts[1]);
                    currentNumber = Integer.parseInt(parts[2]);
                    if (index + 1 >= 0 && index + 1 < numbers.size()) {
                        numbers.add(index + 1, currentNumber);
                    }
                    break;
                case "Reverse":
                    List<Integer> reversedList = new ArrayList<>();
                    index = 0;
                    for (int i = numbers.size() - 1; i >= 0; i--) {
                        reversedList.add(index, numbers.get(i));
                        index++;
                    }
                    numbers = reversedList;
                    break;
            }
            input = scanner.nextLine();
        }
            String output = numbers.toString().replaceAll("[\\[\\],]", "");
            System.out.print(String.join(" ", output));
    }
}
