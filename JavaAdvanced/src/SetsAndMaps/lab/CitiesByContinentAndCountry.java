package SetsAndMaps.lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        //nested map
        Map<String, Map<String, List<String>>> continentsDate = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] parts = scanner.nextLine().split("\\s+");
            String continent = parts[0];
            String country = parts[1];
            String city = parts[2];

            Map<String, List<String>> countryDate = continentsDate.get(continent);
            if (countryDate == null) {
                countryDate = new LinkedHashMap<>();
            }

            List<String> currentCitiesList = countryDate.get(country);
            if (currentCitiesList == null) {
                currentCitiesList = new ArrayList<>();
            }

            currentCitiesList.add(city);
            countryDate.put(country, currentCitiesList);
            continentsDate.put(continent, countryDate);
        }
        continentsDate.forEach((continents, date) -> {
            System.out.println(continents + ":");
            date.forEach((country, cities) -> {
                System.out.printf("  %s -> %s\n", country, String.join(", ", cities));
            });
        });
    }
}
