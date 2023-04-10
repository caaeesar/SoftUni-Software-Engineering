package FirstStepsInCoding.exercise;

import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int pages = Integer.parseInt(scan.nextLine());
        int pagesForHour = Integer.parseInt(scan.nextLine());
        int countDays = Integer.parseInt(scan.nextLine());

        int totalHours = pages / pagesForHour;
        int result = totalHours / countDays;

        System.out.println(result);
    }
}
