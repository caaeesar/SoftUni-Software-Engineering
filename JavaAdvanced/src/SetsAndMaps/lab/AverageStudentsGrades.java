package SetsAndMaps.lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        int allStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < allStudents; i++) {

            String[] studentDate = scanner.nextLine().split("\\s+");
            String name = studentDate[0];
            double grade = Double.parseDouble(studentDate[1]);

            List<Double> currentGradeList = studentsGrades.get(name);
            if (currentGradeList == null) {
                currentGradeList = new ArrayList<>();
            }

            currentGradeList.add(grade);
            studentsGrades.put(name, currentGradeList);
        }

        studentsGrades.forEach((student, grades) -> {
            StringBuilder allGrades = new StringBuilder();
            double average = 0.00;
            for (double currentGrade : grades) {
                allGrades.append(String.format("%.2f ", currentGrade));
                average += currentGrade;
            }
          /*  OptionalDouble average = grades.stream().mapToDouble(e -> e).average();
            if (average.isPresent()) {
                average.getAsDouble();
            }*/
            System.out.printf("%s -> %s(avg: %.2f)\n", student, allGrades, average / grades.size());
        });
    }
}
