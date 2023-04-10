package PBExams.Exam17Decembre17;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String beginning = scanner.nextLine();
        String last = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int firstNumber = 0; firstNumber < 10; firstNumber++) {

            for (int secondNumber = 0; secondNumber < 10; secondNumber++) {

                for (int thirdNumber = 0; thirdNumber < 10; thirdNumber++) {

                    for (int forthNumber = 0; forthNumber < 10; forthNumber++) {

                        int sum = firstNumber + secondNumber + thirdNumber + forthNumber;
                        int multiplication = (firstNumber * thirdNumber) - n;

                        if (sum == multiplication && count < n) {
                            count++;
                            System.out.printf("%s%d%d%d%d%s ", beginning, firstNumber, secondNumber, thirdNumber, forthNumber, last);
                        }
                    }
                }
            }
        }
    }
}
