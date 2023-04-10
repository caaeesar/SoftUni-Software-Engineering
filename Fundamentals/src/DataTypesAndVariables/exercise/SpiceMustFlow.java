package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int totalAmountOfSpice = 0;
        int days = 0;
        int crewConsumes = 26;

        while (yield >= 100) {

            days++;
            totalAmountOfSpice += (yield - crewConsumes);
            yield -= 10;
        }
        if (totalAmountOfSpice != 0) {
            totalAmountOfSpice -= crewConsumes;
        }
        System.out.println(days);
        System.out.print(totalAmountOfSpice);
    }
}
