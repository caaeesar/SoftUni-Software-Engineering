package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SoftUniCoursePlanning {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = new ArrayList<>(Arrays.asList(scanner.nextLine().split(", ")));
        String input = scanner.nextLine();
        String currentLesson;

        while (!"course start".equals(input)) {
            String[] command = input.split(":");

            switch (command[0]) {
                case "Add":
                    currentLesson = command[1];
                    if (!lessons.contains(currentLesson)) {
                        addLesson(lessons, currentLesson);
                    }
                    break;
                case "Insert":
                    currentLesson = command[1];
                    int index = Integer.parseInt(command[2]);
                    if (!lessons.contains(currentLesson)) {
                        insertLesson(lessons, currentLesson, index);
                    }
                    break;
                case "Remove":
                    currentLesson = command[1];
                    if (lessons.contains(currentLesson)) {
                        removeLesson(lessons, currentLesson);
                    }
                    break;
                case "Swap":
                    String lesson1 = command[1];
                    String lesson2 = command[2];
                    if (lessons.contains(lesson1) && lessons.contains(lesson2)) {
                        swapLesson(lessons, lesson1, lesson2);
                    }
                    break;
                case "Exercise":
                    currentLesson = command[1];
                    if (lessons.contains(currentLesson) && !lessons.contains(currentLesson + "-Exercise")) {
                        addExercise(lessons, currentLesson);
                    } else if (!lessons.contains(currentLesson)) {
                        addLesson(lessons, currentLesson);
                        addExercise(lessons, currentLesson);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        int n = 1;
        for (String lesson : lessons) {
            System.out.printf("%d.%s%n", n, lesson);
            n++;
        }
    }

    private static void addExercise(List<String> lessons, String currentLesson) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).equals(currentLesson)) {
                lessons.add(i + 1, currentLesson + "-Exercise");
            }
        }
    }

    private static void swapLesson(List<String> lessons, String lesson1, String lesson2) {
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).equals(lesson1)) {
                index1 = i;
            }
            if (lessons.get(i).equals(lesson2)) {
                index2 = i;
            }
        }
        lessons.set(index1, lesson2);
        lessons.set(index2, lesson1);
        // lesson2 -> index1
        // lesson1 -> index2
        // lesson2Ex -> index2 + 1
        // lesson1Ex -> index1 + 1;
        if (lessons.contains(lesson1 + "-Exercise") && lessons.contains(lesson2 + "-Exercise")) {
            lessons.set(index2 + 1, lesson1 + "-Exercise");
            lessons.set(index1 + 1, lesson2 + "-Exercise");
        } else if (lessons.contains(lesson1 + "-Exercise")) {
            lessons.add(index2 + 1, lesson1 + "-Exercise");
            lessons.remove(index1 + 2); //заради добавения елемент добавяме 2
        } else if (lessons.contains(lesson2 + "-Exercise")) {
            lessons.add(index1 + 1, lesson2 + "-Exercise");
            lessons.remove(index2 + 2);
        }
    }

    private static void removeLesson(List<String> lessons, String currentLesson) {
        for (int index = 0; index < lessons.size(); index++) {
            if (lessons.get(index).equals(currentLesson)) {
                lessons.remove(currentLesson);
                if (lessons.contains(currentLesson + "-Exercise")) {
                    lessons.remove(index);
                }
            }
        }
    }

    private static void insertLesson(List<String> lessons, String currentLesson, int index) {
        lessons.add(index, currentLesson);
    }

    private static void addLesson(List<String> lessons, String currentLesson) {
        lessons.add(currentLesson);
    }
}
