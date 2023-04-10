package Lists.moreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        List<String> nonNumbers = takeNonNumbers(encryptedMessage);
        List<Integer> numbers = takeNumbers(encryptedMessage);
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        getValueOfEvenOddPosition(numbers, takeList, skipList);
        String decryptedMessage = decryptingMessage(nonNumbers, takeList, skipList);
        System.out.print(decryptedMessage);
    }

    private static String decryptingMessage(List<String> nonNumbers, List<Integer> takeList, List<Integer> skipList) {
        String decryptedMessage = "";
        for (int index = 0; index < takeList.size(); index++) {

            int takeCount = takeList.get(index);
            int skipCount = skipList.get(index);
            int taken = 0;
            int skipped = 0;

            if (takeCount > nonNumbers.size()) {
                takeCount = nonNumbers.size();
            }
            while (taken < takeCount) {
                decryptedMessage += nonNumbers.get(0);
                nonNumbers.remove(0);
                taken++;
            }
            if (skipCount > nonNumbers.size()) {
                skipCount = nonNumbers.size();
            }
            while (skipped < skipCount) {
                nonNumbers.remove(0);
                skipped++;
            }
        }
        return decryptedMessage;
    }

    private static void getValueOfEvenOddPosition(List<Integer> numbers, List<Integer> evenPosition, List<Integer> oddPosition) {
        for (int position = 0; position < numbers.size(); position++) {

            if (position % 2 == 0) {
                evenPosition.add(numbers.get(position));
            } else {
                oddPosition.add(numbers.get(position));
            }
        }
    }

    private static List<String> takeNonNumbers(String encryptedMessage) {
        List<String> nonNumber = new ArrayList<>();
        for (int position = 0; position < encryptedMessage.length(); position++) {

            char currentElement = encryptedMessage.charAt(position);

            if (!(currentElement >= '0' && currentElement <= '9')) {
                nonNumber.add(currentElement + "");
            }
        }
        return nonNumber;
    }

    private static List<Integer> takeNumbers(String encryptedMessage) {
        List<Integer> numbers = new ArrayList<>();
        for (int position = 0; position < encryptedMessage.length(); position++) {

            char currentElement = encryptedMessage.charAt(position);

            if (currentElement >= '0' && currentElement <= '9') {
                numbers.add(Integer.valueOf(currentElement + ""));
            }
        }
        return numbers;
    }
}
