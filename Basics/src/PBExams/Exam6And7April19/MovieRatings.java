package PBExams.Exam6And7April19;

import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int allMovies = Integer.parseInt(scanner.nextLine());
        double maxRating = -10.00;
        double minRating = 10.00;
        double allRating = 0.00;
        String movieMax = "";
        String movieMin = "";

        for (int currentMovie = 1; currentMovie <= allMovies; currentMovie++) {

           String movieName = scanner.nextLine();
            double currentRating = Double.parseDouble(scanner.nextLine());
            allRating += currentRating;

            if (currentRating > maxRating) {
                maxRating = currentRating;
                movieMax = movieName;
            }

            if (currentRating < minRating) {
                minRating = currentRating;
                movieMin = movieName;
            }
        }
        System.out.printf("%s is with highest rating: %.1f%n", movieMax, maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n", movieMin, minRating);

        double averageRating = allRating / allMovies;
        System.out.printf("Average rating: %.1f", averageRating);
    }
}
