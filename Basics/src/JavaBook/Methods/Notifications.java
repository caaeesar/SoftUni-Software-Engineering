package JavaBook.Methods;

import java.util.Scanner;

public class Notifications {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int totalNotifications = Integer.parseInt(scanner.nextLine());

        for (int notification = 1; notification <= totalNotifications; notification++) {

            readAndProcessMessage(scanner);
            System.out.println();
        }
    }

    static void showSuccessMessage(String operation, String message) {

        String heading = String.format("Successfully executed %s.", operation);
        System.out.println(heading);
        System.out.println(printEqually("=", heading.length()));
        System.out.println(message + ".");
    }

    static void showWarningMessage(String message) {

        String heading = String.format("Warning: %s.", message);
        System.out.println(heading);
        System.out.println(printEqually("=", heading.length()));
    }

    static void showErrorMessage(String operation, String message, int code) {

        String heading = String.format("Error: Failed to execute %s.", operation);
        System.out.println(heading);
        System.out.println(printEqually("=", heading.length()));
        System.out.printf("Reason: %s.%n", message);
        System.out.printf("Error code: %d.%n", code);
    }

    static void readAndProcessMessage(Scanner scanner) {

        String messageType = scanner.nextLine();

        switch (messageType) {

            case "success":

                String successOperation = scanner.nextLine();
                String successMessage = scanner.nextLine();

                showSuccessMessage(successOperation, successMessage);
                break;

            case "warning":

                String warningMessage = scanner.nextLine();

                showWarningMessage(warningMessage);
                break;
            case "error":

                String errorOperation = scanner.nextLine();
                String errorMessage = scanner.nextLine();
                int errorCode = Integer.parseInt(scanner.nextLine());

                showErrorMessage(errorOperation, errorMessage, errorCode);
                break;
        }
    }

    static String printEqually(String symbol, int count) {

        String text = "";

        for (int i = 1; i <= count; i++) {

            text += symbol;
        }
        return text;
    }
}
