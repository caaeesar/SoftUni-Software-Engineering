package InterfacesAndAbstraction.lab.Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String driverName = scanner.nextLine();

        Car ferrari = new Ferrari(driverName);
        System.out.println(ferrari);
    }
}
