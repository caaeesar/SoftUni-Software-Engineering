package RegularExpressions.lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);
                           // 1 capturing group ()
        String regex = "\\+359([\\s-])2\\1[\\d]{3}\\1[\\d]{4}\\b";
                                         // back reference
                                        //1 same thing like first group
        Pattern patter = Pattern.compile(regex);
        String phoneNumbers = scanner.nextLine();
        Matcher phoneMatcher = patter.matcher(phoneNumbers);

        List<String> validPhoneNumbers = new LinkedList<>();
        while (phoneMatcher.find()) {
            validPhoneNumbers.add(phoneMatcher.group(0));
        }
            System.out.print(String.join(", ", validPhoneNumbers));
    }
}
