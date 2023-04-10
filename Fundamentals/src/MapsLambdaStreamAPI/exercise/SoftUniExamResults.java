package MapsLambdaStreamAPI.exercise;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

                Map<String, Integer> studentsTotalPoint = new LinkedHashMap<>();
                Map<String, Integer> languagesSubmissionCounts = new LinkedHashMap<>();

                String command = scanner.nextLine();
                while (!command.equals("exam finished")) {
                    String[] examInformation = command.split("-");
                    String username = examInformation[0];
                    String language = "";
                    int point = 0;

                    if (!command.contains("banned")) {
                        language = examInformation[1];
                        point = Integer.parseInt(examInformation[2]);

                        // няма такъв студент:
                        Integer currentPoint = studentsTotalPoint.get(username);
                        if (currentPoint == null) {
                            currentPoint = 0;
                            studentsTotalPoint.put(username, currentPoint + point);

                            Integer currentSubCount = languagesSubmissionCounts.get(language);
                            if (currentSubCount == null) { // няма събмити за този език
                                currentSubCount = 0;
                            }
                            languagesSubmissionCounts.put(language, currentSubCount + 1);
                        } else { // има такъв студент:
                            // ако събмита е на съшия език
                            if (currentPoint < point) {
                                studentsTotalPoint.put(username, point);
                            }
                            Integer currentSubCount = languagesSubmissionCounts.get(language);
                            if (currentSubCount == null) { // няма събмити на този език
                                currentSubCount = 0;
                            }
                            languagesSubmissionCounts.put(language, currentSubCount + 1);
                        }
                    } else {
                        studentsTotalPoint.remove(username);
                    }
                    command = scanner.nextLine();
                }
                System.out.println("Results:");
                for (Map.Entry<String, Integer> entry : studentsTotalPoint.entrySet()) {
                    System.out.printf("%s | %d\n", entry.getKey(), entry.getValue());
                }
                System.out.println("Submissions:");
                for (Map.Entry<String, Integer> entry : languagesSubmissionCounts.entrySet()) {
                    System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());
                }
            }
        }


       /* String command = scanner.nextLine();
        Map<String, Integer> studentsPoint = new LinkedHashMap<>();
        Map<String, Integer> languagesSubmissions = new LinkedHashMap<>();
        String username = "";
        int points = 0;

        while (!"exam finished".equals(command)) {

            String[] information = command.split("-");
            if (command.contains("banned")) {
                username = information[0];
                studentsPoint.remove(username);
            } else {
                username = information[0];
                String language = information[1];
                points = Integer.parseInt(information[2]);

                if (!studentsPoint.containsKey(username)) {
                    studentsPoint.put(username, points);
                } else {
                    if (studentsPoint.get(username) < points) {
                        studentsPoint.put(username, points);
                    }
                }

                if (!languagesSubmissions.containsKey(language)) {
                    languagesSubmissions.put(language, 1);
                } else {
                    Integer currentSubmissions = languagesSubmissions.get(language);
                    languagesSubmissions.put(language, currentSubmissions + 1);
                }
            }
            command = scanner.nextLine();
        }

        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : studentsPoint.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languagesSubmissions.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }*/

