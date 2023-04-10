package Lists.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
//todo 70/100
        List<String> data = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        String input = scanner.nextLine();

        while (!"3:1".equals(input)) {
            String[] operation = input.split(" ");

            switch (operation[0]) {

                case "merge":
                    mergingElement(data, Integer.parseInt(operation[1]), Integer.parseInt(operation[2]));
                    break;
                case "divide":
                    dividingElement(data, Integer.parseInt(operation[1]), Integer.parseInt(operation[2]));
                    break;
            }
            input = scanner.nextLine();
        }
        for (String srt : data) {
            System.out.printf("%s ", srt);
        }
    }

    private static void dividingElement(List<String> data, int indexDivide, int partitions) {

        indexDivide = indexValidation(indexDivide, data.size());

        String strForDived = data.get(indexDivide);
        int length = strForDived.length();
        boolean isEqualPart = length % partitions == 0;
        int separatedSymbols = length / partitions;
        int lastPartLength = 0;
        if (!isEqualPart) {
            lastPartLength = (length - partitions) + separatedSymbols;//todo
        }
        StringBuilder separatedStr = new StringBuilder();
        int countParts = 0;
        int countSymbols = 0;
        int position = 0;

        while (countParts != partitions) {

            while (position < length) {

                if (!isEqualPart && countParts == partitions - 1) {
                    separatedSymbols = lastPartLength;
                }

                char currentSymbol = strForDived.charAt(position);
                separatedStr.append(currentSymbol);
                countSymbols++;
                position++;

                if (countSymbols == separatedSymbols) {
                    countSymbols = 0;
                    break;
                }
            }
            separatedStr.append(" ");
            countParts++;
        }
        data.set(indexDivide, separatedStr.toString());
    }

    private static int indexValidation(int index, int size) {
        if (index < 0) {
            index = 0;
        } else if (index > size - 1) {
            index = size - 1;
        }
        return index;
    }

    private static void mergingElement(List<String> data, int startIndex, int endIndex) {
        //If any of the given indexes is out of the array, you must take ONLY the range that is INSIDE the array and merge it.
        startIndex = indexValidation(startIndex,data.size());
        endIndex = indexValidation(endIndex,data.size());

        String concatenatedString = "";
        for (int i = startIndex; i < endIndex; i++) {
            // not include, because concatenate two elements together
            concatenatedString = data.get(startIndex) + data.get(startIndex + 1);
            data.set(startIndex, concatenatedString);
            data.remove(data.get(startIndex + 1));
        }
    }
}
