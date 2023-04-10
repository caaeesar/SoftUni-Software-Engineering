package ConditionalStatements.exercise;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());         // в сек.
        double distance = Double.parseDouble(scanner.nextLine());      //  в метри
        double timeForMetre = Double.parseDouble(scanner.nextLine()); // времето, за което преплува 1 м.

        double hisTime = distance * timeForMetre;            // получаваме сек., за които ще преплува разстоянието
        double resistance = Math.floor(distance / 15) * 12.5;  // водно съпротивление = на 15 м се забавя с 12.5 сек.
                                                              // делим, за да разберем колко пъти в дистанцията има 15 м.
                                                             // умножаваме сек., с които се забавяне
        double totalTime = hisTime + resistance;   // забавянето увеличава неговото време
        boolean isImprove = totalTime < record;

        if (isImprove) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else {
            double needTime = totalTime - record;
            System.out.printf("No, he failed! He was %.2f seconds slower.", needTime);
        }
    }
}
