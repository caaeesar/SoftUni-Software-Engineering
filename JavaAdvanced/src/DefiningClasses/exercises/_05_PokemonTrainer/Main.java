package DefiningClasses.exercises._05_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainersInfo = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {

            String trainerName = input.split("\\s")[0];

            String pokemonName = input.split("\\s")[1];
            String pokemonElement = input.split("\\s")[2];
            int health = Integer.parseInt(input.split("\\s")[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, health);

            Trainer currentTrainer = trainersInfo.get(trainerName);
            if (currentTrainer == null) {
                currentTrainer = new Trainer(trainerName);
                currentTrainer.addPokemon(pokemon);
             } else {
                currentTrainer.addPokemon(pokemon);
            }
            trainersInfo.put(trainerName,currentTrainer);


            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"End".equals(input)) {

            String searchElement = input;

            for (Map.Entry<String, Trainer> entry : trainersInfo.entrySet()) {

                Trainer trainer = entry.getValue();
                if (trainer.isHavePokemonElement(searchElement)) {
                    trainer.receiveBadge();
                } else {
                    trainer.decreasingPokemonHealth();
                }
            }
            input = scanner.nextLine();
        }
     trainersInfo
             .values()
             .stream()
             .sorted(Comparator.comparing(Trainer::getBadges).reversed())
             .forEach(System.out::println);
    }
}
