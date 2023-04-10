package DefiningClasses.exercises._07_CatLady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String END = "End";
    public static final String SIAMESE = "Siamese";
    public static final String CYMRIC = "Cymric";
    public static final String STREET_EXTRAORDINAIRE = "StreetExtraordinaire";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        List<Cat> allCats = new ArrayList<>();
        String input = scanner.nextLine();
        while (!END.equals(input)) {

            String breed = input.split("\\s")[0];
            String name = input.split("\\s")[1];
            switch (breed) {
                case SIAMESE:
                    double earSize = Double.parseDouble(input.split("\\s")[2]);
                    Cat siamese = new Siamese(name, earSize);
                    allCats.add(siamese);
                    break;
                case CYMRIC:
                    double furLength = Double.parseDouble(input.split("\\s")[2]);
                    Cat cymric = new Cymric(name, furLength);
                    allCats.add(cymric);
                    break;
                case STREET_EXTRAORDINAIRE:
                    double decibelsOfMeows = Double.parseDouble(input.split("\\s")[2]);
                    Cat streetExtraordinaire = new StreetExtraordinaire(name, decibelsOfMeows);
                    allCats.add(streetExtraordinaire);
                    break;
            }
            input = scanner.nextLine();
        }

        String searchCatName = scanner.nextLine();
        for (Cat cat : allCats) {
            if (cat.getName().equals(searchCatName)) {
                System.out.println(cat);
            }
        }

    }
}
