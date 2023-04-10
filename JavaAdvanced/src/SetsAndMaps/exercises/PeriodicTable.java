package SetsAndMaps.exercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Set<String> chemicalCompound = new TreeSet<>();

        int allElements = Integer.parseInt(scanner.nextLine());
        while (allElements-- > 0) {

            String[] parts = scanner.nextLine().split("\\s+");
            for (String element : parts) {
                chemicalCompound.add(element);
            }
            // chemicalCompound.addAll(Arrays.asList(parts));
        }
        System.out.print(chemicalCompound.toString().replaceAll("[\\[\\],]", ""));
    }
}
