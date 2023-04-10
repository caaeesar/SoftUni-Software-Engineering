package SetsAndMaps.exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String currentUsername = scanner.nextLine();
            usernames.add(currentUsername);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
