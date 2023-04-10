package TextProcessing.moreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int[] keys = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        while (!"find".equals(command)) {

            String encryptedMessage = command;
            StringBuilder decryptedMessage = new StringBuilder(encryptedMessage.length());

            int indexKey = 0;
            for (int index = 0; index < encryptedMessage.length(); index++) {

                if (indexKey == keys.length) {
                    indexKey = 0;
                }
                char symbol = encryptedMessage.charAt(index);
                int currentKey = keys[indexKey];
                char newSymbol = (char) (symbol - currentKey);
                decryptedMessage.append(newSymbol);
                indexKey++;
            }

            int indexType1 = decryptedMessage.indexOf("&");
            int indexType2 = decryptedMessage.lastIndexOf("&");
            String type = decryptedMessage.substring(indexType1 + 1, indexType2);
            int startCoordinateIndex = decryptedMessage.indexOf("<");
            int endCoordinateIndex = decryptedMessage.indexOf(">");
            String coordinates = decryptedMessage.substring(startCoordinateIndex + 1, endCoordinateIndex);

            System.out.printf("Found %s at %s%n", type, coordinates);
            command = scanner.nextLine();
        }

    }
}
