package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int snowballs = Integer.parseInt(scanner.nextLine());
        double snowballMaxValue = Double.NEGATIVE_INFINITY;
        int snowballSnowMax = 0;
        int snowballMaxTime = 0;
        int snowballMaxQuality = 0;

        for (int currentSnowball = 1; currentSnowball <= snowballs; currentSnowball++) {

            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double currentValue = Math.pow(snowballSnow * 1.00 / snowballTime, snowballQuality);

            if (currentValue > snowballMaxValue) {
                snowballMaxValue = currentValue;
                snowballSnowMax = snowballSnow;
                snowballMaxTime = snowballTime;
                snowballMaxQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",snowballSnowMax, snowballMaxTime,snowballMaxValue,snowballMaxQuality);
    }
}
