package RegularExpressions.moreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket2 {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
//todo 90/100
        //@@@@@@##########@@@@
        //^^^^^^@@@@^^^^^^@@@@ - > 6^

        String[] tickets = scanner.nextLine().trim().split(",\\s+");

        for (String currentTicket : tickets) {

            currentTicket = currentTicket.replaceAll("\\s", "");

            if (currentTicket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            String leftPart = currentTicket.substring(0, currentTicket.length() / 2);
            String rightPart = currentTicket.substring(leftPart.length());

            Pattern pattern = Pattern.compile("[@]{6,10}|[\\^]{6,10}|[$]{6,10}|[#]{6,10}");
            Matcher matcherLeftPart = pattern.matcher(leftPart);
            Matcher matcherRightPart = pattern.matcher(rightPart);

            boolean isHaveWinSymbols = matcherLeftPart.find() && matcherRightPart.find();

            if (!isHaveWinSymbols) {
                System.out.printf("ticket \"%s\" - no match%n", currentTicket);
            }
            if (isHaveWinSymbols) {

                String leftMatch = matcherLeftPart.group();
                int leftLength = leftMatch.length();

                String rightMatch = matcherRightPart.group();
                int rightLength = rightMatch.length();

                if (!leftMatch.equals(rightMatch) && (leftLength < 6 || rightLength < 6)) {
                    System.out.printf("ticket \"%s\" - no match%n", currentTicket);
                }

                if ((leftLength >= 6 && leftLength < 10) && (rightLength >= 6 && rightLength < 10)) {
                    char matchSymbol = leftMatch.charAt(0);
                    System.out.printf("ticket \"%s\" - %d%c%n"
                            , currentTicket, leftLength, matchSymbol);
                } else if (leftLength == 10 && rightLength == 10 && leftMatch.equals(rightMatch)) {
                    char matchSymbol = leftMatch.charAt(0);
                    System.out.printf("ticket \"%s\" - %d%c Jackpot!%n"
                            , currentTicket, leftLength, matchSymbol);
                } else if (leftLength > rightLength) {
                    char matchSymbol = rightMatch.charAt(0);
                    System.out.printf("ticket \"%s\" - %d%c%n"
                            , currentTicket, rightLength, matchSymbol);
                } else if (rightLength > leftLength) {
                    char matchSymbol = leftMatch.charAt(0);
                    System.out.printf("ticket \"%s\" - %d%c%n"
                            , currentTicket, leftLength, matchSymbol);
                }
            }
        }
    }
}