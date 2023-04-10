package SetsAndMaps.exercises;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class PopulationCounter {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> statisticMap = new LinkedHashMap<>();
        // Map<String, Long> countryPopulation = new HashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)) {

            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);

            /*Long totalPopulation = countryPopulation.get(country);
            if (totalPopulation == null) {
                totalPopulation = 0L;
            }
            countryPopulation.put(country, totalPopulation + population);*/

            Map<String, Long> citiesPopulation = statisticMap.get(country);
            if (citiesPopulation == null) {
                citiesPopulation = new HashMap<>();
            }

            citiesPopulation.put(city, population);
            statisticMap.put(country, citiesPopulation);
            input = scanner.nextLine();
        }
        statisticMap.entrySet().stream()
                .sorted((country1, country2) ->
                        country2.getValue().values().stream().reduce(0L, Long::sum)
                                .compareTo(country1.getValue().values().stream().reduce(0L, Long::sum)))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)\n",
                            country.getKey(), country.getValue().values().stream().reduce(0L, Long::sum));
                    country.getValue().entrySet().stream()
                            .sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                            .forEach(city -> System.out.printf("=>%s: %d\n", city.getKey(), city.getValue()));
                });
    }
}
