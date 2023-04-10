package TextProcessing.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        /*
         * List<String> inputList = Arrays.stream(scanner.nextLine()
         *                         .split(""))
         *                         .collect(Collectors.toList());
         *
         *         int index = 0;
         *         while (index < inputList.size() - 1) {
         *
         *             String element1 = inputList.get(index);
         *             String element2 = inputList.get(index + 1);
         *
         *             if (element1.equals(element2)) {
         *                 inputList.remove(index + 1);
         *             } else  {
         *                 index++;
         *             }
         *         }
         *         String output = inputList.toString().replaceAll("[\\[\\], ]","");
         *         System.out.print(output);
         */
        char[] charSequence = scanner.nextLine().toCharArray();
        List<Character> characterList = new ArrayList<>();

        for (char c : charSequence) {
            characterList.add(c);
        }

        int index = 0;
        while (index < characterList.size() - 1) {

            char currentSymbol = characterList.get(index);
            char nextSymbol = characterList.get(index + 1);

            if (currentSymbol == nextSymbol) {
                characterList.remove(index);
            } else {
                index++;
            }
        }
        characterList.forEach(System.out::print);
    }
}
