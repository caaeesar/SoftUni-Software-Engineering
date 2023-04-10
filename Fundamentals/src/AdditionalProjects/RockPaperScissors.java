package AdditionalProjects;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        final String ROCK = "Rock";
        final String PAPER = "Paper";
        final String SCISSORS = "Scissors";

        System.out.println("Choose [r]ock, [p]aper or [s]cissors:");
        String input = scanner.nextLine();
        String playerChoice = "";

        if (input.equalsIgnoreCase(ROCK) ||
                input.equalsIgnoreCase("r")) {
            playerChoice = "Rock";
        } else if (input.equalsIgnoreCase(PAPER) ||
                input.equalsIgnoreCase("p")) {
            playerChoice = "Paper";
        } else if (input.equalsIgnoreCase(SCISSORS) ||
                input.equalsIgnoreCase("s")) {
            playerChoice = "Scissors";
        } else {
            System.out.println("Invalid input. Try again!");
            return;
        }

        String[] allOptions = {ROCK, PAPER, SCISSORS};
        Random random = new Random();
        int randomIndex = random.nextInt(allOptions.length);
        String randomComputerChoice = allOptions[randomIndex];
        System.out.printf("Computer chose %s%n", randomComputerChoice);

        String result = "";
        if ((playerChoice.equals(ROCK) && randomComputerChoice.equals(SCISSORS)) ||
                (playerChoice.equals(PAPER) && randomComputerChoice.equals(ROCK)) ||
                (playerChoice.equals(SCISSORS) && randomComputerChoice.equals(PAPER))) {
            result = "You win";
        } else if ((playerChoice.equals(ROCK) && randomComputerChoice.equals(PAPER)) ||
                (playerChoice.equals(PAPER) && randomComputerChoice.equals(SCISSORS)) ||
                (playerChoice.equals(SCISSORS) && randomComputerChoice.equals(ROCK))) {
            result = "You lose";
        } else {
            result = "Draw";
        }

        System.out.println(result);
    }
}
