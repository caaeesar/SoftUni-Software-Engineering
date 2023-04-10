package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class Demo {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine(); // Melissa
        int age = Integer.parseInt(scanner.nextLine()); // 20
        boolean isValid = name.equals("Melissa");
        if (!isValid || age < 19) {
            System.out.print("Hello");
        } else {
            System.out.print("Hello Melissa");
        }
    }
}
