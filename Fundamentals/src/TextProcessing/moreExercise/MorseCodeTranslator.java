package TextProcessing.moreExercise;

import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] morseCode = scanner.nextLine().split(" ");
        StringBuilder translatedMessage = new StringBuilder();

        for (int index = 0; index < morseCode.length; index++) {

            String code = morseCode[index];

            switch (code) {
                case "|":
                    translatedMessage.append(" ");
                    break;
                case ".-":
                    translatedMessage.append("A");
                    break;
                case "-...":
                    translatedMessage.append("B");
                    break;
                case "-.-.":
                    translatedMessage.append("C");
                    break;
                case "-..":
                    translatedMessage.append("D");
                    break;
                case ".":
                    translatedMessage.append("E");
                    break;
                case "..-.":
                    translatedMessage.append("F");
                    break;
                case "--.":
                    translatedMessage.append("G");
                    break;
                case "....":
                    translatedMessage.append("H");
                    break;
                case "..":
                    translatedMessage.append("I");
                    break;
                case ".---":
                    translatedMessage.append("J");
                    break;
                case "-.-":
                    translatedMessage.append("K");
                    break;
                case ".-..":
                    translatedMessage.append("L");
                    break;
                case "--":
                    translatedMessage.append("M");
                    break;
                case "-.":
                    translatedMessage.append("N");
                    break;
                case "---":
                    translatedMessage.append("O");
                    break;
                case ".--.":
                    translatedMessage.append("P");
                    break;
                case "--.-":
                    translatedMessage.append("Q");
                    break;
                case ".-.":
                    translatedMessage.append("R");
                    break;
                case "...":
                    translatedMessage.append("S");
                    break;
                case "-":
                    translatedMessage.append("T");
                    break;
                case "..-":
                    translatedMessage.append("U");
                    break;
                case "...-":
                    translatedMessage.append("V");
                    break;
                case ".--":
                    translatedMessage.append("W");
                    break;
                case "-..-":
                    translatedMessage.append("X");
                    break;
                case "-.--":
                    translatedMessage.append("Y");
                    break;
                case "--..":
                    translatedMessage.append("Z");
                    break;

            }
        }
        System.out.println(translatedMessage);
    }
}
