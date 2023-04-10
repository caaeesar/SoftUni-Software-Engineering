package MapsLambdaStreamAPI.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * Map<String, String> parkingValidation = new LinkedHashMap<>();
         *         int countOfLines = Integer.parseInt(scanner.nextLine());
         *         for (int currentLine = 1; currentLine <= countOfLines; currentLine++) {
         *
         *             String[] usersDate = scanner.nextLine().split("\\s");
         *             String command = usersDate[0];
         *             String user = usersDate[1];
         *
         *             String currentCarNumber = parkingValidation.get(user);
         *
         *             switch (command) {
         *                 case "register":
         *                     String licensePlateNumber = usersDate[2];
         *                     if (currentCarNumber != null) {
         *                         if (currentCarNumber.equals(licensePlateNumber)) {
         *                             System.out.printf("ERROR: already registered with plate number %s\n", licensePlateNumber);
         *                         }
         *                     } else {
         *                         parkingValidation.put(user, licensePlateNumber);
         *                         System.out.printf("%s registered %s successfully\n", user, licensePlateNumber);
         *                     }
         *                     break;
         *                 case "unregister":
         *                     if (currentCarNumber != null) {
         *                         System.out.printf("%s unregistered successfully\n", user);
         *                         parkingValidation.remove(user);
         *                     } else {
         *                         System.out.printf("ERROR: user %s not found\n", user);
         *                     }
         *                     break;
         *             }
         *         }
         */


        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Map<String, String> registry = new LinkedHashMap<>();
        String username = "";

        for (int currentLine = 0; currentLine < numberOfCommands; currentLine++) {

            String[] information = scanner.nextLine().split(" ");
            String command = information[0];

            switch (command) {
                case "register":
                    username = information[1];
                    String licensePlateNumber = information[2];
                    registration(registry, username, licensePlateNumber);
                    break;
                case "unregister":
                    username = information[1];
                    unregistration(registry, username);
                    break;
            }
        }

        for (Map.Entry<String, String> entry : registry.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }

    static void registration(Map<String, String> registry, String username, String licensePlateNumber) {

        if (!registry.containsKey(username)) {
            registry.put(username, licensePlateNumber);
            System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
        } else {
            System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
        }
    }

    static void unregistration(Map<String, String> registry, String username) {

        if (!registry.containsKey(username)) {
            System.out.printf("ERROR: user %s not found%n", username);
        } else {
            System.out.printf("%s unregistered successfully%n", username);
            registry.remove(username);
        }
    }
}
