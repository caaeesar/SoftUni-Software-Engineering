package SetsAndMaps.exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {

            String name = input;
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                map.put(name, email);
            }
            input = scanner.nextLine();
        }
        map.forEach((name, email) -> System.out.printf("%s -> %s\n", name, email));
    }
}
