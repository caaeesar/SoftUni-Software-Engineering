package WorkingWithAbstraction.lab.StudentSystemRefactor;

import java.util.Scanner;

public class Main {
    public static final String EXIT = "Exit";
    public static final String CREATE = "Create";
    public static final String SHOW = "Show";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem system = new StudentSystem();
        String[] information = scanner.nextLine().split("\\s+");

        String command = information[0];
        while (!EXIT.equals(command)) {
            String name = information[1];

            switch (command) {
                case CREATE:
                    int age = Integer.parseInt(information[2]);
                    double grade = Double.parseDouble(information[3]);
                    system.createStudent(name, age, grade);
                    break;
                case SHOW:
                    system.showStudent(name);
                    break;
            }
            information = scanner.nextLine().split("\\s+");
            command = information[0];
        }
    }
}
