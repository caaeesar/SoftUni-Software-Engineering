package NestedLoops.exercise;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        int students = 0;
        int standards = 0;
        int kids = 0;
        int totalTickets = 0;

        while (!input1.equals("Finish")) {

            String move = input1;
            int currentFreeSeats = Integer.parseInt(scanner.nextLine());
            String input2 = scanner.nextLine();
            int currentAllTickets = 0;

            while (!input2.equals("End")) {

                String typeTicket = input2;
                totalTickets++;
                currentAllTickets++;

                switch (typeTicket) {
                    case "student":
                        students++;
                        break;
                    case "standard":
                        standards++;
                        break;
                    case "kid":
                        kids++;
                        break;
                }
                if (currentFreeSeats == currentAllTickets) {
                    break;
                }
                input2 = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.\n", move, (currentAllTickets * 1.00 / currentFreeSeats) * 100);
            input1 = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d\n", totalTickets);
        System.out.printf("%.2f%% student tickets.\n", (students * 1.00 / totalTickets) * 100);
        System.out.printf("%.2f%% standard tickets.\n", (standards * 1.00 / totalTickets) * 100);
        System.out.printf("%.2f%% kids tickets.\n", (kids * 1.00 / totalTickets) * 100);

    }
}
