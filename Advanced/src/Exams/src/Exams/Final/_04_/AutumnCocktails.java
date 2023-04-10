package Exams.Final._04_;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredients::offer);

        Deque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(freshness::push);

        Map<String, Integer> cocktailsCount = new TreeMap<>();
        cocktailsCount.put("Pear Sour", 0);
        cocktailsCount.put("The Harvest", 0);
        cocktailsCount.put("Apple Hinny", 0);
        cocktailsCount.put("High Fashion", 0);

        int countSour = 0;
        int countHarvest = 0;
        int countHinny = 0;
        int countFashion = 0;

        boolean isPartyTime = false;

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {

            int currentIngredient = ingredients.pop();
            if (currentIngredient == 0) {
                continue;
            }
            int currentFreshLevel = freshness.poll();


            int product = currentIngredient * currentFreshLevel;

            String currentCocktail = "";
            if (product == 150) {
                currentCocktail = "Pear Sour";
                countSour++;
            } else if (product == 250) {
                currentCocktail = "The Harvest";
                countHarvest++;
            } else if (product == 300) {
                currentCocktail = "Apple Hinny";
                countHinny++;
            } else if (product == 400) {
                currentCocktail = "High Fashion";
                countFashion++;
            } else {
                currentIngredient += 5;
                ingredients.offerLast(currentIngredient);
            }

            if (!currentCocktail.isEmpty()) {
                int currentCount = cocktailsCount.get(currentCocktail);
                cocktailsCount.put(currentCocktail, currentCount + 1);
            }

            if (countSour >= 1 && countHarvest >= 1 && countHinny >= 1 && countFashion >= 1) {
                isPartyTime = true;
                // break;
            }
        }

        if (isPartyTime) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int leftSum = 0;
            for (Integer ingredient : ingredients) {
                leftSum += ingredient;
            }
            System.out.printf("Ingredients left: %d\n", leftSum);
        }

        cocktailsCount
                .entrySet()
                .stream()
                .filter(c -> c.getValue() != 0)
                .forEach(c -> System.out.printf(" # %s --> %d\n", c.getKey(), c.getValue()));

    }
}
