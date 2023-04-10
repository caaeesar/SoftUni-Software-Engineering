package Generics.exercises._04_Threeuple;

import java.util.Arrays;
import java.util.Scanner;

public class _04_Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] line = Arrays.stream(scanner.nextLine().split("\\s"))
                .toArray(String[]::new);

        String name;

        name = line[0] + " " + line[1];
        String address = line[2];
        String town = line[3];

        Threeuple<String, String, String> t1 = new Threeuple<>(name, address, town);


        line = Arrays.stream(scanner.nextLine().split("\\s"))
                .toArray(String[]::new);

        name = line[0];
        Integer litersOfBeer = Integer.parseInt(line[1]);
        Boolean drunkOrNor = line[2].equals("drunk");

        Threeuple<String, Integer,Boolean> t2 = new Threeuple<>(name,litersOfBeer,drunkOrNor);


        line = Arrays.stream(scanner.nextLine().split("\\s"))
                .toArray(String[]::new);
        name = line[0];
        Double accountBalance = Double.parseDouble(line[1]);
        String bankName = line[2];

        Threeuple<String, Double,String> t3 = new Threeuple<>(name,accountBalance,bankName);


        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
