package JavaBook.ExamPreparationPart1;

import java.util.Scanner;

public class Sums3Numbers {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        //  по условие първото събираемо е по-малкото число от двете събираеми;
        if (a + b == c) {
            if (a < b) {
                System.out.printf("%d + %d = %d", a, b, c);
            } else { // a > b
                System.out.printf("%d + %d = %d", b, a, c);
            }
        } else if (a + c == b) {
            if (a < c) {
                System.out.printf("%d + %d = %d", a, c, b);
            } else { // a > c
                System.out.printf("%d + %d = %d", c, a, b);
            }
        } else if (b + c == a) {
            if (b < c) {
                System.out.printf("%d + %d = %d", b, c, a);
            } else { // b > c
                System.out.printf("%d + %d = %d", c, b, a);
            }
        } else {
            System.out.print("No");
        }
    }
}
