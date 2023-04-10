package ForLoop.moreExercise;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

     /*   int period = Integer.parseInt(scanner.nextLine()); // брой дни, в които ще идват пациенти всеки ден;
        int doctors = 7;
        int treated = 0;
        int untreated = 0;
        int totalTreated = 0;
        int totalUntreated = 0; */


       /* for (int days = 1; days <= period; days++) {
            int currentPatient = Integer.parseInt(scanner.nextLine()); // брой текущи пациенти за деня;

            if ((days % 3 == 0) && (totalUntreated > totalTreated)) {
                ++doctors;
            }
            if (currentPatient <= doctors) {
                treated = doctors;
                if (currentPatient < doctors) {
                    treated = currentPatient;
                }
                totalTreated += treated;
            } else {
                untreated = currentPatient - doctors;
                totalUntreated += untreated;
                totalTreated += doctors;
            }
        }
        System.out.println("Treated patients: " + totalTreated + ".");
        System.out.println("Untreated patients: " + totalUntreated + ".");

        */

      /*  for (int days = 1; days <= period; days++) {
            int currentPatient = Integer.parseInt(scanner.nextLine()); // брой текущи пациенти за деня;

            if ((days % 3 == 0) && (totalUntreated > totalTreated)) { // на всеки три дни се прави проверка
                ++doctors;
            }
            if (currentPatient <= doctors) {
                treated = currentPatient;
                totalTreated += treated;
            } else {
                untreated = currentPatient - doctors;
                totalUntreated += untreated;
                totalTreated += doctors;
            }
        }
        System.out.println("Treated patients: " + totalTreated + ".");
        System.out.println("Untreated patients: " + totalUntreated + "."); */


        int period = Integer.parseInt(scanner.nextLine());
        int countDay = 0;
        int doctors = 7;
        int treated = 0;
        int untreated = 0;

        for (int day = 1; day <= period; day++) {
            ++countDay;
            if (countDay == 3) {
                if (untreated > treated) {
                    doctors += 1;
                }
                countDay = 0;
            }
            int currentPatient = Integer.parseInt(scanner.nextLine());
            if (currentPatient < doctors) {
                treated += currentPatient;
            } else if (currentPatient == doctors) {
                treated += doctors;
            } else if (currentPatient > doctors) {
                untreated += currentPatient - doctors;
                treated += Math.abs((currentPatient - doctors) - currentPatient); // или само doctors
            }                       //   неизлекуваните        -  брой на пациентите
        }
        System.out.printf("Treated patients: %d.\n", treated);
        System.out.printf("Untreated patients: %d.", untreated);
    }
}
