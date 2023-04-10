package SetsAndMaps.lab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> studentsScores = new TreeMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        while (numberOfStudents-- > 0) {

            String name = scanner.nextLine();
            double[] allScores = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            Double averageScore = studentsScores.get(name);

            if (averageScore == null) {
                averageScore = 0.00;
            }

            for (Double score : allScores) {
                averageScore += score;
            }
           /* OptionalDouble currentAverage = Arrays.stream(allScores).average();
            if (currentAverage.isPresent()) {
                averageScore = currentAverage.getAsDouble();
            }*/

            studentsScores.put(name, (averageScore / allScores.length));
        }
        studentsScores.forEach((student, average) -> System.out.printf("%s is graduated with %s\n", student, average));
    }
}
