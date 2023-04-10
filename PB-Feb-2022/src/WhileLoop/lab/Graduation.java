package WhileLoop.lab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double average = 0.00;
        int currentClass = 1;

        while (currentClass <= 12) {
            double grade = Double.parseDouble(scanner.nextLine());
            average += grade;

            if (grade < 4) {
                System.out.printf("%s has been excluded at %d grade", name, currentClass);
                break;
            }
            if (currentClass == 12) {
                System.out.printf("%s graduated. Average grade: %.2f", name, average / 12);
                break;
            }
            ++currentClass;
        }
    }
}
