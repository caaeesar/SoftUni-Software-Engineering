package ObjectsAndClasses.lab.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();
        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            boolean isUpdateDate = false;
            String[] studentDate = command.split("\\s+");
            Student currentStudent = new Student
                    (studentDate[0], studentDate[1], Integer.parseInt(studentDate[2]), studentDate[3]);

            for (Student existedStudent : studentsList) {

                if (existedStudent.getFirstName().equals(currentStudent.getFirstName()) &&
                        existedStudent.getLastName().equals(currentStudent.getLastName())) {
                    existedStudent.setAge(currentStudent.getAge());
                    existedStudent.setHomeTown(currentStudent.getHomeTown());
                    isUpdateDate = true;
                }
            }

            if (!isUpdateDate) {
            studentsList.add(currentStudent);
            }

            command = scanner.nextLine();
        }
        String searchTown = scanner.nextLine();
        studentsList.stream().filter(st -> st.getHomeTown().equals(searchTown)).forEach(System.out::println);
    }
}
