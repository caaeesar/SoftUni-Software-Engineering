package ConditionalStatements.moreExercise;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int v = Integer.parseInt(scan.nextLine());    // Обем на басейна в литри
        int p1 = Integer.parseInt(scan.nextLine());  // дебит на първата тръба за час
        int p2 = Integer.parseInt(scan.nextLine()); // дебит на втората тръба за час
        double hours = Double.parseDouble(scan.nextLine()); // часовете които работникът отсъства

        double firstPipe = p1 * hours;   // литри, които е напълнила за това време
        double secondPipe = p2 * hours; // -//-
        double both = firstPipe + secondPipe; // литрите,които и двете са напълнили

        boolean isFull = both <= v;

        if (isFull) {
            double wholePercentage = (both / v) * 100;
            double firstPer = (firstPipe / both) * 100;
            double secondPer = (secondPipe / both) * 100;
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", wholePercentage, firstPer, secondPer);
        } else { // boolean overFull > both
            double overFull = both - v;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", hours, overFull);
        }

    }
}
