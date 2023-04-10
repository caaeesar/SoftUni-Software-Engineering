package JavaBook.ExamPreparationPart2;

import java.util.Scanner;

public class Distance {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int startSpeed = Integer.parseInt(scanner.nextLine()); // първоначална скорост
        // превръщам минутите в часове, защото е км/ч;
        double firstTime = Integer.parseInt(scanner.nextLine()) / 60.0;
        double secondTime = Integer.parseInt(scanner.nextLine()) / 60.0;
        double thirdTime = Integer.parseInt(scanner.nextLine()) / 60.0;

        double firstDistance = startSpeed * firstTime; // първоначалното разстояние
        double upSpeed = startSpeed + (startSpeed * 0.1); // скоростта, с която се увеличава
        double afterUpSpeed = upSpeed * secondTime; // изминатото разстояние с тази скорост
        double downSpeed = upSpeed - (upSpeed * 0.05); // скоростта, с която се намалява
        double afterDownSpeed = downSpeed * thirdTime; // изминатото разстояние с тази скорост

        double total = firstDistance + afterUpSpeed + afterDownSpeed;

        System.out.printf("%.2f", total);


    }
}
