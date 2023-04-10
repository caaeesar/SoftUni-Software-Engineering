package PBExams.Exam15And16June19;

import java.util.Scanner;

public class MovieProfit {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int tickets = Integer.parseInt(scanner.nextLine());
        double priceTicket = Double.parseDouble(scanner.nextLine());
        int percentForCinema = Integer.parseInt(scanner.nextLine());

        double priceForDay = tickets * priceTicket;
        double totalSum = priceForDay * days;
        double profit = totalSum - ((totalSum * percentForCinema) / 100);

        System.out.printf("The profit from the movie %s is %.2f lv.", movieName, profit);
    }
}
