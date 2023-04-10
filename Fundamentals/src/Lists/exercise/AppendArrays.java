package Lists.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<String> arrays = new ArrayList<>((Arrays.asList(scanner.nextLine().split("\\|"))));
        Collections.reverse(arrays);
        String toPrint = arrays.toString().replaceAll("[\\]\\[,]", "").trim();
        System.out.println(String.join(" ",toPrint));

        /*
         *  String input = scanner.nextLine();
         *
         *         List<String> lineSeparatedByPipe = Arrays.stream(input.split("\\|")).collect(Collectors.toList());
         *
         *         Collections.reverse(lineSeparatedByPipe);
         *
         *         System.out.print(lineSeparatedByPipe.toString()
         *                 .replace("[","")
         *                 .replace("]","")
         *                 .replaceAll(",","")
         *                 .trim()
         *                 .replaceAll("\\s+"," "));
         */
    }
}
