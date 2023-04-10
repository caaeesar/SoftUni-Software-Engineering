package MapsLambdaStreamAPI.exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*              // index[0] = totalGrades ; index[1] = countOfGrages
         * Map<String, List<Double>> studentsDate = new LinkedHashMap<>();
         *
         *         int nLines = Integer.parseInt(scanner.nextLine());
         *         for (int currentLine = 1; currentLine <= nLines; currentLine++) {
         *
         *             String studentName = scanner.nextLine();
         *             double grade = Double.parseDouble(scanner.nextLine());
         *
         *             List<Double> currentTotalGradesAndCount = studentsDate.get(studentName);
         *             if (currentTotalGradesAndCount == null) {
         *                 currentTotalGradesAndCount = new ArrayList<>(2);
         *                 currentTotalGradesAndCount.add(0.00);
         *                 currentTotalGradesAndCount.add(0.00);
         *             }
         *             currentTotalGradesAndCount.set(0, currentTotalGradesAndCount.get(0) + grade);
         *             currentTotalGradesAndCount.set(1, currentTotalGradesAndCount.get(1) + 1);
         *             studentsDate.put(studentName, currentTotalGradesAndCount);
         *         }
         *         studentsDate.entrySet().stream().filter(s -> (s.getValue().get(0) / s.getValue().get(1)) >= 4.50)
         *                 .forEach(s -> System.out.printf("%s -> %.2f\n", s.getKey(), s.getValue().get(0) / s.getValue().get(1)));
         */

        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();
        int pairOfRows = Integer.parseInt(scanner.nextLine());

        for (int currentLine = 0; currentLine < pairOfRows; currentLine++) {

            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            List<Double> currentGradesList = studentsGrades.get(studentName);
            if (currentGradesList == null) {
                currentGradesList = new ArrayList<>();
            }
            currentGradesList.add(grade);
            studentsGrades.put(studentName, currentGradesList);
        }

        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {

            double countGrades = entry.getValue().size();
            double totalGrades = 0.00;
            for (Double currentGrade : entry.getValue()) {
                totalGrades += currentGrade;
            }
            double averageGrade = totalGrades / countGrades;
            if (averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);
            }
        }
    }
}
