package ObjectsAndClasses.exercise.students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        int countOfStudent = Integer.parseInt(scanner.nextLine());
        List<Student> studentsList = new ArrayList<>(countOfStudent);

        for (int currentLine = 1; currentLine <= countOfStudent ; currentLine++) {

            String[] studentInfo = scanner.nextLine().split(" ");
            Student student = new Student(studentInfo[0],studentInfo[1],Double.parseDouble(studentInfo[2]));
            studentsList.add(student);
        }
     studentsList.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).forEach(System.out::println);
    }
}
