package Exams.Retake._02_;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
//fixme
public class KAT {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<Long> licensePlates = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", *"))
                .map(Long::parseLong)
                .forEach(licensePlates::offer);

        Deque<Long> cars = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", *"))
                .map(Long::parseLong)
                .forEach(cars::push);

        long registeredCars = 0;
        long leftLicense = 0;
        long days = 0;

        while (!licensePlates.isEmpty() && !cars.isEmpty()) {

            days++;
            long currentLicenses = licensePlates.poll();
            long currentCars = cars.pop();

            long needPlates = currentCars * 2;

            if (currentLicenses < needPlates) {
                registeredCars += (currentLicenses / 2);
                long leftCars = (currentCars - (currentLicenses / 2));
                cars.push(leftCars);
            } else if (currentLicenses > needPlates) {
                registeredCars += currentCars;
                leftLicense += (currentLicenses / needPlates);
                licensePlates.offerLast(leftLicense);
            } else {
                registeredCars += currentCars;
            }
        }

        System.out.printf("%d cars were registered for %d days!\n", registeredCars, days);
        if (!licensePlates.isEmpty()) {
            System.out.printf("%d license plates remain!\n", leftLicense);
        } else if (!cars.isEmpty()) {
            int leftCars = 0;
            for (long car : cars) {
                leftCars += car;
            }
            System.out.printf("%d cars remain without license plates!\n", leftCars);
        } else {
            System.out.println("Good job! There is no queue in front of the Exams.Retake.myExam._02_.KAT!");
        }

    }
}
