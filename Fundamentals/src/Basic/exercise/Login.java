package Basic.exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();
        String correctPass = "";

        for (int position = userName.length() - 1; position >= 0 ; position--) {
            char c = userName.charAt(position);
            correctPass += c;
        }
        int countFails = 0;
        String currentPass = scanner.nextLine();
        while (!currentPass.equals(correctPass)) {
            countFails++;
            if (countFails == 4) {
                System.out.printf("User %s blocked!",userName);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            currentPass = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", userName);
    }
}
