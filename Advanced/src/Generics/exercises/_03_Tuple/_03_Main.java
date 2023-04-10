package Generics.exercises._03_Tuple;

import java.util.Scanner;

public class _03_Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        String firstName = line.split("\\s")[0];
        String lastName = line.split("\\s")[1];
        String names = firstName + " " + lastName;

        String address = line.split("\\s")[2];

        Tuple<String, String> tuple1 = new Tuple<>(names, address);
        System.out.println(tuple1);


        line = scanner.nextLine();

        String name = line.split("\\s")[0];
        Integer litersOfBeer = Integer.parseInt(line.split("\\s")[1]);

        Tuple<String, Integer> tuple2 = new Tuple<>(name, litersOfBeer);
        System.out.println(tuple2);


        line = scanner.nextLine();

        Integer number1 = Integer.parseInt(line.split("\\s")[0]);
        Double number2 = Double.parseDouble(line.split("\\s")[1]);

        Tuple<Integer, Double> tuple3 = new Tuple<>(number1, number2);
        System.out.println(tuple3);

    }
}
