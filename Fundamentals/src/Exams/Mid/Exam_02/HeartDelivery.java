package Exams.Mid.Exam_02;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();

        int countHouseWithVDs = 0;
        int currentHouseIndex = 0;

        String command = scanner.nextLine();
        while (!"Love!".equals(command)) {
            String[] parts = command.split(" ");
            int jumpLength = Integer.parseInt(parts[1]);
            currentHouseIndex += jumpLength;
            if (currentHouseIndex >= houses.length) {
                currentHouseIndex = 0;
            }
            if (houses[currentHouseIndex] == 0) {
                System.out.printf("Place %d already had Valentine's day.\n", currentHouseIndex);
            } else {
                int numberOfHearts = houses[currentHouseIndex];
                numberOfHearts -= 2;
                houses[currentHouseIndex] = numberOfHearts;
                if (numberOfHearts == 0) {
                    System.out.printf("Place %d has Valentine's day.\n", currentHouseIndex);
                    countHouseWithVDs++;
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.\n", currentHouseIndex);
        if (countHouseWithVDs == houses.length) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", houses.length - countHouseWithVDs);
        }
    }
}
