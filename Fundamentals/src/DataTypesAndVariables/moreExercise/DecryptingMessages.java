package DataTypesAndVariables.moreExercise;

import java.util.Scanner;

public class DecryptingMessages {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int characters = Integer.parseInt(scanner.nextLine());
        String message = "";

        for (int currentSymbol = 1; currentSymbol <= characters ; currentSymbol++) {

            char encryptedSymbol = scanner.nextLine().charAt(0);
            int decryptedSymbol = encryptedSymbol + key;
            message += (char)decryptedSymbol;
        }
        System.out.print(message);
    }
}
