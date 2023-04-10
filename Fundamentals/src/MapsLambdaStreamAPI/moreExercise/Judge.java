package MapsLambdaStreamAPI.moreExercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Judge {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         *
         // contest    student   point
         Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
         Map<String, List<Integer>> studentsPoints = new TreeMap<>();
         String command = scanner.nextLine();

         while (!"no more time".equals(command)) {

         String[] information = command.split("->");
         String username = information[0].trim();
         String contest = information[1].trim();
         int point = Integer.parseInt(information[2].trim());
         boolean isHaveBetterPoint = false;

         Map<String, Integer> currentStudentPoint = contests.get(contest);
         List<Integer> currentPoints = studentsPoints.get(username);
         if (!contests.containsKey(contest)) { // check if such a contest already exists

         if (currentPoints == null) {
         currentPoints = new ArrayList<>();
         }
         currentStudentPoint = new HashMap<>();

         } else {

         if (currentPoints == null) {
         currentPoints = new ArrayList<>();
         }

         //check if the current user is participating in the contest
         if (contests.get(contest).containsKey(username)) {
         isHaveBetterPoint = true;
         //take the higher score
         if (contests.get(contest).get(username) > point) {
         command = scanner.nextLine();
         continue;
         }
         }
         }
         if (isHaveBetterPoint) { // remove the worse point from individual statistics
         studentsPoints.get(username).remove(contests.get(contest).get(username));
         }
         currentPoints.add(point);
         studentsPoints.put(username, currentPoints);
         currentStudentPoint.put(username, point);
         contests.put(contest, currentStudentPoint);

         command = scanner.nextLine();
         }

         AtomicInteger position = new AtomicInteger();
         for (Map.Entry<String, Map<String, Integer>> entry : contests.entrySet()) {

         position.set(1);
         String contest = entry.getKey();
         Map<String, Integer> studentsPoint = entry.getValue();

         System.out.printf("%s: %d participants%n", contest, studentsPoint.size());

         studentsPoint.entrySet()
         .stream()
         .sorted((e1, e2) -> {
         // sorted by point in descending order
         int sort = Integer.compare(e2.getValue(), e1.getValue());
         if (sort == 0) { // then ordered by name in ascending order
         sort = e1.getKey().compareTo(e2.getKey());
         }
         return sort;
         }).forEach(element -> {
         System.out.printf("%d. %s <::> %d%n", position.getAndAdd(1), element.getKey(), element.getValue());
         });
         }

         // summing total point
         Map<String, Integer> studentsTotalPoint = new TreeMap<>();
         for (Map.Entry<String, List<Integer>> entry : studentsPoints.entrySet()) {

         Integer totalPoint = 0;
         for (Integer point : entry.getValue()) {
         totalPoint += point;
         }
         studentsTotalPoint.put(entry.getKey(), totalPoint);
         }

         position.set(1);
         System.out.println("Individual standings:");
         studentsTotalPoint.entrySet().stream().sorted((p1, p2) -> {
         int sort = Integer.compare(p2.getValue(), p1.getValue());
         if (sort == 0) {
         sort = p1.getKey().compareTo(p2.getKey());
         }
         return sort;
         }).forEach(element -> System.out.printf("%d. %s -> %d%n", position.getAndAdd(1), element.getKey(), element.getValue()));
         */

        // contest    username, point
        Map<String, Map<String, Integer>> contestsStudentsPoint = new LinkedHashMap<>();

        // student totalPoint
        Map<String, Integer> individualStatistics = new TreeMap<>();

        String command = scanner.nextLine();
        while (!"no more time".equals(command)) {

            String[] parts = command.split(" -> ");
            String username = parts[0];
            String contest = parts[1];
            int point = Integer.parseInt(parts[2]);

            // info for username and point
            Map<String, Integer> currentInfo = contestsStudentsPoint.get(contest);

            // ако няма текуща информация за този contest:
            // инициализираме вътрешния мап:
            if (currentInfo == null) {
                currentInfo = new HashMap<>();
            }
            // инициализираме ключа на вътрешния мап:
            Integer currentPoint = currentInfo.get(username);
            if (currentPoint == null) {
                currentPoint = 0;
            }

            Integer currentTotalPoint = individualStatistics.get(username);
            // ако за този contest вече има такъв студент
            if (currentInfo.containsKey(username)) {
                // проверяваме точките му за този contest
                if (currentPoint > point) {
                    command = scanner.nextLine();
                    continue;
                } else {
                    if (currentTotalPoint != null) {
                        currentTotalPoint -= currentPoint;
                    }
                }
            }
            if (currentTotalPoint == null) {
                currentTotalPoint = 0;
            }
            individualStatistics.put(username, currentTotalPoint + point);
            currentInfo.put(username, point);
            contestsStudentsPoint.put(contest, currentInfo);
            command = scanner.nextLine();
        }
        AtomicInteger position = new AtomicInteger();

        contestsStudentsPoint.forEach((key, value) -> {
            position.set(1);
            System.out.printf("%s: %d participants\n", key, value.size());

            value.entrySet().stream().sorted((s1, s2) -> {
                int result = Integer.compare(s2.getValue(), s1.getValue());
                if (result == 0) {
                    result = s1.getKey().compareTo(s2.getKey());
                }
                return result;
            }).forEach(s -> System.out.printf("%d. %s <::> %d\n", position.getAndAdd(1), s.getKey(), s.getValue()));
        });

        System.out.println("Individual standings:");
        position.set(1);
        individualStatistics.entrySet().stream().sorted((s1, s2) -> {
            int result = Integer.compare(s2.getValue(), s1.getValue());
            if (result == 0) {
                result = s1.getKey().compareTo(s2.getKey());
            }
            return result;
        }).forEach(s -> System.out.printf("%d. %s -> %d\n", position.getAndAdd(1), s.getKey(), s.getValue()));
    }
}
