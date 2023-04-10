package MapsLambdaStreamAPI.exercise;

import java.util.*;

public class Courses {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courseStudents = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] information = command.split(":");
            String courseName = information[0];
            String student = information[1];

            List<String> registeredStudents = courseStudents.get(courseName);
            if (registeredStudents == null) {
                registeredStudents = new ArrayList<>();
            }
            registeredStudents.add(student);
            courseStudents.put(courseName, registeredStudents);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courseStudents.entrySet()) {

            System.out.printf("%s: %d%n", entry.getKey().trim(), entry.getValue().size());
            for (String student : entry.getValue()) {
                System.out.printf("-- %s%n", student.trim());
            }
        }
    }
}
