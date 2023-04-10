package Lists.moreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer text = new StringBuffer("");

        List<String> numbers = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        String str = scanner.nextLine();
        text.append(str);
        int index = 0;
        String message = "";

        for (int currentIndex = 0; currentIndex < numbers.size(); currentIndex++) {
            String currentElement = numbers.get(currentIndex);

            for (int position = 0; position < currentElement.length(); position++) {
                char currentValue = currentElement.charAt(position);
                index += Integer.parseInt(currentValue + "");

                if (index > text.length()) {
                    index = index - text.length();
                }
            }
            char specialSymbol = text.charAt(index);
            message += specialSymbol;
            text = text.deleteCharAt(index);
            index = 0;
        }
        System.out.print(message);
    }
}

