package RegularExpressions.moreExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
//todo 80/100

        String[] allTickets = Arrays.stream(scanner.nextLine().split("[,]\\s+")).toArray(String[]::new);

        for (String currentTicket : allTickets) {

            currentTicket = currentTicket.replaceAll("\\s", "");

            boolean isValid = currentTicket.length() == 20;
            boolean isJackpot = false;

            if (isValid) {

                // Jackpot:
                String regexJackpot = "[@]{20}|[\\^]{20}|[$]{20}|[#]{20}";
                Pattern patternJackpot = Pattern.compile(regexJackpot);
                Matcher matcherJackpot = patternJackpot.matcher(currentTicket);

                if (matcherJackpot.find()) {
                    char symbol = matcherJackpot.group().charAt(0);
                    isJackpot = true;
                    System.out.printf("ticket \"%s\" - 10%c Jackpot!\n", currentTicket, symbol);
                }

                if (!isJackpot) {

                    String leftPart = currentTicket.substring(0, currentTicket.length() / 2);
                    String rightPart = currentTicket.substring(currentTicket.length() / 2);
                    String regex = "[@]{6,9}|[\\^]{6,9}|[$]{6,9}|[#]{6,9}";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcherLeft = pattern.matcher(leftPart);
                    Matcher matcherRight = pattern.matcher(rightPart);

                    //match
                    if (matcherLeft.find() && matcherRight.find()) {
                        int leftCountSymbol = matcherLeft.group().length();
                        int rightCountSymbol = matcherRight.group().length();
                        if (leftCountSymbol >= 6 && rightCountSymbol >= 6) {
                            char symbolLeft = matcherLeft.group().charAt(0);
                            char symbolRight = matcherRight.group().charAt(0);
                            if (leftCountSymbol > rightCountSymbol) {
                                System.out.printf("ticket \"%s\" - %d%c\n", currentTicket, leftCountSymbol, symbolLeft);
                                continue;
                            } else {
                                System.out.printf("ticket \"%s\" - %d%c\n", currentTicket, rightCountSymbol, symbolRight);
                                continue;
                            }
                        }
                    }
                    //no match
                    System.out.printf("ticket \"%s\" - no match\n", currentTicket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
