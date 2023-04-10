package Exams.Mid.Exam_01;

import java.util.Scanner;

public class SoftUniReception {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(scanner.nextLine());

        int unhandledStudents = Integer.parseInt(scanner.nextLine());
        int totalTime = 1;

        while (unhandledStudents > 0) {

            if (totalTime % 4 == 0) {
                totalTime++;
                continue;
            }
            int totalHandleStPerHour = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
            unhandledStudents -= totalHandleStPerHour;
            totalTime++;
        }
        System.out.printf("Time needed: %dh.", totalTime - 1);
    }
}
