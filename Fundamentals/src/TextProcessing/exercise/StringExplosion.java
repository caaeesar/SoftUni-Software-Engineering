package TextProcessing.exercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        int totalStrength = 0;

        int index = 0;
        while (index < input.length()) {

            char symbol = input.charAt(index);
            if (symbol == '>') {

                int currentStrength = Integer.parseInt(input.charAt(index + 1) + "");
                totalStrength += currentStrength;

            } else if (symbol != '>' && totalStrength > 0) {

                input.deleteCharAt(index);
                totalStrength--;
                index--;
            }
            index++;
        }
        System.out.println(input);
    }
}
