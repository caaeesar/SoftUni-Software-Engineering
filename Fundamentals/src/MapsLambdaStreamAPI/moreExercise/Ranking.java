package MapsLambdaStreamAPI.moreExercise;

import java.util.*;

public class Ranking {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * String input = scanner.nextLine();
         *         Map<String, String> contestsPass = new HashMap<>();
         *         while (!"end of contests".equals(input)) {
         *
         *             String[] information = input.split(":");
         *             String contest = information[0];
         *             String password = information[1];
         *
         *             contestsPass.put(contest, password);
         *
         *             input = scanner.nextLine();
         *         }
         *         //  name       contest  point -> ThreeMap
         *         Map<String, Map<String, Integer>> candidatesContestsPoints = new TreeMap<>();
         *         String command = scanner.nextLine();
         *         while (!"end of submissions".equals(command)) {
         *
         *             String[] information = command.split("=>");
         *             String contest = information[0];
         *             String password = information[1];
         *             String username = information[2];
         *             int point = Integer.parseInt(information[3]);
         *
         *             Map<String, Integer> contestsPoint = candidatesContestsPoints.get(username);
         *             if (contestsPass.containsKey(contest) && contestsPass.get(contest).equals(password)) {
         *
         *                 if (contestsPoint == null) {
         *                     contestsPoint = new HashMap<>();
         *                 } else {
         *                     // If you receive the same contest and the same user, update the points only
         *                     // if the new ones are more than the older ones
         *                     if (candidatesContestsPoints.get(username).containsKey(contest)) {
         *                         if (candidatesContestsPoints.get(username).get(contest) > point) {
         *                             command = scanner.nextLine();
         *                             continue;
         *                         }
         *                     }
         *                 }
         *                 contestsPoint.put(contest, point);
         *                 candidatesContestsPoints.put(username, contestsPoint);
         *             }
         *             command = scanner.nextLine();
         *         }
         *
         *         Map<String, Integer> candidateMaxPoint = new HashMap<>();
         *         for (Map.Entry<String, Map<String, Integer>> entry : candidatesContestsPoints.entrySet()) {
         *
         *             int currentPoints = 0;
         *             for (Integer point : entry.getValue().values()) {
         *                 currentPoints += point;
         *                 candidateMaxPoint.put(entry.getKey(), currentPoints);
         *             }
         *         }
         *
         *         String bestCandidate = "";
         *         int maxPoint = Integer.MIN_VALUE;
         *         for (Map.Entry<String, Integer> entry : candidateMaxPoint.entrySet()) {
         *
         *             if (entry.getValue() > maxPoint) {
         *                 maxPoint = entry.getValue();
         *                 bestCandidate = entry.getKey();
         *             }
         *         }
         *         System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, maxPoint);
         *
         *         System.out.println("Ranking:");
         *         for (Map.Entry<String, Map<String, Integer>> entry : candidatesContestsPoints.entrySet()) {
         *
         *             String key = entry.getKey();
         *             Map<String, Integer> value = entry.getValue();
         *             System.out.printf("%s%n", key);
         *
         *             value.entrySet()
         *                     .stream()
         *                     .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
         *                     .forEach(element -> System.out.printf("#  %s -> %d%n", element.getKey(), element.getValue()));
         *         }
         */

        // student  // contest, point
        Map<String, Map<String, Integer>> studentsContestPoint = new TreeMap<>();
        //  student, totalPoint
        Map<String, Integer> studentsTotalPoint = new HashMap<>();
        Map<String, String> validContestsPassword = new HashMap<>();

        String input = scanner.nextLine();
        while (!"end of contests".equals(input)) {

            String[] parts = input.split(":");
            String contest = parts[0];
            String password = parts[1];
            validContestsPassword.put(contest, password);
            input = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!"end of submissions".equals(command)) {

            String[] parts = command.split("=>");
            String contest = parts[0];
            String password = parts[1];
            String student = parts[2];
            int point = Integer.parseInt(parts[3]);

            boolean isValidPassword = false;
            if (validContestsPassword.containsKey(contest)) {
                String validPassword = validContestsPassword.get(contest);
                if (password.equals(validPassword)) {
                    isValidPassword = true;
                }
            }

            if (isValidPassword) {

                Map<String, Integer> currentStudentInfo = studentsContestPoint.get(student);
                // нямаме такъв студент все още и трябва да добавим информация за него:
                if (currentStudentInfo == null) {
                    currentStudentInfo = new TreeMap<>();
                }

                Integer currentPoint = currentStudentInfo.get(contest);
                if (currentPoint == null) {
                    currentPoint = 0;
                }

                Integer currentTotalPoint = studentsTotalPoint.get(student);
                // проверяваме текущите точки на студента:
                if (currentPoint > point) {
                    command = scanner.nextLine();
                    continue;
                } else { // ако има по-висок резултат, трябва да извадим предишния от общия брой
                    if (currentTotalPoint != null) {
                        currentTotalPoint -= currentPoint;
                    }
                }

                currentStudentInfo.put(contest, point);
                studentsContestPoint.put(student, currentStudentInfo);

                // добавяме в общия брой точки:
                if (currentTotalPoint == null) {
                    currentTotalPoint = 0;
                }
                studentsTotalPoint.put(student, currentTotalPoint + point);
            }
            command = scanner.nextLine();
        }

        int totalPoint = Collections.max(studentsTotalPoint.values());
        studentsTotalPoint.entrySet().stream()
                .filter(s -> s.getValue() == totalPoint)
                .forEach(s -> {
                    System.out.printf("Best candidate is %s with total %d points.\n", s.getKey(), totalPoint);
                });

        System.out.println("Ranking:");
        studentsContestPoint.forEach((key, value) -> {
            System.out.printf("%s\n", key);
            value.entrySet().stream()
                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                    .forEach(c -> {
                        System.out.printf("#  %s -> %d\n", c.getKey(), c.getValue());
                    });
        });
    }
}
