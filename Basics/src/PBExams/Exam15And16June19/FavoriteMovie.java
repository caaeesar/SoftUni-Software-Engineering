package PBExams.Exam15And16June19;

import java.util.Scanner;

public class FavoriteMovie {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int maxPoint = Integer.MIN_VALUE;
        int countMovies = 0;
        String bestMovie = "";

        while (!"STOP".equals(command)) {

            String movieName = command;
            int length = movieName.length();
            countMovies++;
            int currentPoint = 0;

            for (int position = 0; position < length; position++) {

                char currentSymbol = movieName.charAt(position);

                if (currentSymbol >= 'a' && currentSymbol <= 'z') {

                    currentPoint += (currentSymbol - (2 * length));

                } else if (currentSymbol >= 'A' && currentSymbol <= 'Z') {

                    currentPoint += (currentSymbol - length);

                } else {
                    currentPoint += currentSymbol;
                }
            }
            if (currentPoint > maxPoint) {
                maxPoint = currentPoint;
                bestMovie = movieName;
            }
            if (countMovies == 7) {
                System.out.println("The limit is reached.");
                break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", bestMovie, maxPoint);
    }
}


