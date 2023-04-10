package Methods.lab;

import java.util.Scanner;

public class Grades {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());
        printGradeWithWords(grade);
    }

    static void printGradeWithWords(double grades) {

        /*
         * 2.00 – 2.99 - "Fail"
         * 3.00 – 3.49 - "Poor"
         * 3.50 – 4.49 - "Good"
         * 4.50 – 5.49 - "Very good"
         * 5.50 – 6.00 - "Excellent"
         */

        if (grades >= 2.00 && grades < 3.00) {
            System.out.print("Fail");
        }else if (grades <= 3.49) {
            System.out.print("Poor");
        } else if (grades <= 4.49) {
            System.out.print("Good");
        } else if (grades <= 5.49) {
            System.out.print("Very good");
        } else {
            System.out.print("Excellent");
        }
    }
}
