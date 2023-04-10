package SetsAndMaps.lab;

import java.util.*;

public class SoftUniParty {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vipList = new TreeSet<>();
        Set<String> regularList = new TreeSet<>();

        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {
            String reservation = input;
            char symbol = reservation.charAt(0);

            if (Character.isDigit(symbol)) {
                vipList.add(reservation);
            } else {
                regularList.add(reservation);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"END".equals(input)) {

            String reservation = input;
            char symbol = reservation.charAt(0);

            if (Character.isDigit(symbol)) {
                vipList.remove(reservation);
            } else {
                regularList.remove(reservation);
            }
            input = scanner.nextLine();
        }

        System.out.println(vipList.size() + regularList.size());
        for (String r : vipList) {
            System.out.println(r);
        }
        for (String r : regularList) {
            System.out.println(r);
        }
    }
}
