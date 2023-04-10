package FirstStepsInCoding.moreExercise;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        double celsius = Double.parseDouble(scan.nextLine());
        double fahrenheit = (celsius * 1.8000) + 32.00;
                //℃ * 1.8000 + 32.00

        System.out.printf("%.2f",fahrenheit);
    }
}
