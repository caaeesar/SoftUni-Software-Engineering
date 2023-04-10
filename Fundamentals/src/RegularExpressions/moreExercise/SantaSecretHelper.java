package RegularExpressions.moreExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantaSecretHelper {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        List<String> goodChildrenList = new LinkedList<>();

        String command = scanner.nextLine();
        while (!"end".equals(command)) {

            String encryptedInfo = command;
            String decryptedMessage = decrypting(key, encryptedInfo);

            Pattern patternValidInfo = Pattern.compile("@(?<name>[A-Za-z]+)[^@!:>\\-]*!(?<behaviour>G|N)!");
            Matcher matcherValidInfo = patternValidInfo.matcher(decryptedMessage);
            while (matcherValidInfo.find()) {

                String name = matcherValidInfo.group("name");
                String behaviour = matcherValidInfo.group("behaviour");

                if (behaviour.equals("G")) {
                    goodChildrenList.add(name);
                }
            }
            command = scanner.nextLine();
        }
        for (String child : goodChildrenList) {
            System.out.println(child);
        }
    }

    static String decrypting(int key, String message) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int index = 0; index < message.length(); index++) {

            char currentSymbol = message.charAt(index);
            char newSymbol = (char) (currentSymbol - key);
            decryptedMessage.append(newSymbol);
        }
        return decryptedMessage.toString();
    }
}
