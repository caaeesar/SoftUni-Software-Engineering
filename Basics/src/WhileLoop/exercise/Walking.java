package WhileLoop.exercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int goal = 10000;
        String input = scanner.nextLine(); // текста - "1000";
        int totalSteps = 0;
        boolean passGoal = false;

        while (!input.equals("Going home")) {

            int currentSteps = Integer.parseInt(input); // искам текста 1000 да го превърнеш в число от целочислен тип;
            totalSteps += currentSteps;

            if (totalSteps >= goal) {
                passGoal = true;
                break;
            }
            input = scanner.nextLine();
        }

        if (input.equals("Going home")) {

            input = scanner.nextLine();
            int stepsToHome = Integer.parseInt(input);
            totalSteps += stepsToHome;

            if (totalSteps >= goal) {
                passGoal = true;
            }
        }
        if (passGoal) {
            int leftSteps = totalSteps - goal;
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", leftSteps);
        } else {
            int needSteps = goal - totalSteps;
            System.out.printf("%d more steps to reach goal.", needSteps);
        }
    }
}
