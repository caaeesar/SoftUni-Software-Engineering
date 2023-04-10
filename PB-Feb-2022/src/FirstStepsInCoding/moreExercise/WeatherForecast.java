package FirstStepsInCoding.moreExercise;

import java.util.Scanner;

public class WeatherForecast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String forecast = scan.nextLine();

        if (forecast.equals("sunny")) {
            System.out.print("It's warm outside!");
        } else {
            System.out.print("It's cold outside!");
        }
    }
}
