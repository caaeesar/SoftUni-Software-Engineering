package Exams.Mid.Exam_01;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double sum = numbers.stream().mapToInt(Integer::intValue).sum();
        double averageNumber = sum / numbers.size();

        List<Integer> topFiveNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number > averageNumber) {
                topFiveNumbers.add(number);
            }
        }
        Collections.sort(topFiveNumbers);
        Collections.reverse(topFiveNumbers);
        topFiveNumbers.stream().limit(5).forEach(e -> System.out.print(e + " "));

        if (topFiveNumbers.isEmpty()) {
            System.out.print("No");
        }
    }
}
