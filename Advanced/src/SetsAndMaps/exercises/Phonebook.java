package SetsAndMaps.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String command = scanner.nextLine();
        while (!"search".equals(command)) {

            String name = command.split("-")[0];
            String number = command.split("-")[1];
            phonebook.put(name, number);

            command = scanner.nextLine();
        }

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {

            String searchName = input;

            if (phonebook.containsKey(searchName)) {
                System.out.printf("%s -> %s\n", searchName, phonebook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.\n", searchName);
            }

            input = scanner.nextLine();
        }

    }
}
