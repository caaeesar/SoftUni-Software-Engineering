package JavaBook;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine(); // leap - 366 ; normal - 365
        int holidays = Integer.parseInt(scanner.nextLine()); //брой празници в годината
        int weekends = Integer.parseInt(scanner.nextLine()); // броя, в които си пътува до родния град в неделя

        double holidayPlaying = holidays * (2.00 / 3.00); // празнични дни, в които играе
        int weekendsSofia = 48 - weekends;               // броя уикенди в София
        double weekendsPlaying = weekendsSofia * (3.00 / 4.00); // уикенди, в които играе
        double playSofia = holidayPlaying + weekendsPlaying;  // общо колко пъти играе в София
        double totalPlay = playSofia + weekends;  // общо колко играе в София и в родния му град

        switch (year) {
            case "leap":
                totalPlay = Math.floor(totalPlay + (totalPlay * 0.15));
                System.out.printf("%.0f", totalPlay);
                break;
            case "normal":
                System.out.printf("%.0f", Math.floor(totalPlay));
                break;
        }
    }
}
