package Exams.Final.Exam_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> validPlaces = new ArrayList<>();

        String regex = "([=\\/])(?<place>[A-Z]{1}[A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            validPlaces.add(matcher.group("place"));
        }

        int totalPoints = 0;
        for (String currentPlace : validPlaces) {
            int length = currentPlace.length();
            totalPoints += length;
        }
        System.out.println("Destinations: " + String.join(", ", validPlaces));
        System.out.printf("Travel Points: %d", totalPoints);
    }
}
