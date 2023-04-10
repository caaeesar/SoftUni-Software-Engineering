package Basic.moreExercise;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
         char c = str.charAt(i);
         reversed += c;
        }
        System.out.print(reversed);
    }
}
