package RegularExpressions.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        //"^|\\s[a-z0-9]+(\\.?|\\-?|_?)[a-z0-9]*@[a-z]+-?[a-z]*(\\.[a-z]+)+";
        //"^|\\s([0-9a-z]+(-?|_?|\\.?)[0-9a-z]*@[a-z]+-?[a-z]*(\\.[a-z]+)+)";

        String regexEmail = "\\b(?<users>[a-z0-9]+[\\.\\-_]?[a-z0-9]*)@(?<host>[a-z]+-?[a-z]*(\\.[a-z]+)+)\\b";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcherEmail = pattern.matcher(text);
        while (matcherEmail.find()) {
            System.out.println(matcherEmail.group());
        }
    }
}
