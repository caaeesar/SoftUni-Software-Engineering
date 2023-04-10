package DataTypesAndVariables.exercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int initPower = pokePower;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int targetsCount = 0;

        while (pokePower >= distance) {

            pokePower -= distance;
            targetsCount++;

            if (pokePower == initPower * 0.5) {
                if (exhaustionFactor != 0) {
                    pokePower /= exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(targetsCount);
    }
}
