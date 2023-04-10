package ForLoop.exercise;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());
        int allPeople = 0;
        double group1 = 0;
        double group2 = 0;
        double group3 = 0;
        double group4 = 0;
        double group5 = 0;

        for (int i = 1; i <= groups; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            allPeople += people;

            // гранични ситуации
            if (people <= 5) {  //изкачват Мусала
                group1 += people;
            } else if (people <= 12) { // изкачват Монблан
                group2 += people;
            } else if (people <= 25) { //изкачват Килиманджаро
                group3 += people;
            } else if (people <= 40) { // изкачват К2
                group4 += people;
            } else { // изкачват Еверест
                group5 += people;

            }
        }
        double percent1 = (group1 / allPeople) * 100;
        double percent2 = (group2 / allPeople) * 100;
        double percent3 = (group3 / allPeople) * 100;
        double percent4 = (group4 / allPeople) * 100;
        double percent5 = (group5 / allPeople) * 100;
        System.out.printf("%.2f%%\n", percent1);
        System.out.printf("%.2f%%\n", percent2);
        System.out.printf("%.2f%%\n", percent3);
        System.out.printf("%.2f%%\n", percent4);
        System.out.printf("%.2f%%", percent5);
    }
}
