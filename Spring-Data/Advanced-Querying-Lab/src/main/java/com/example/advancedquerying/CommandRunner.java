package com.example.advancedquerying;

import com.example.advancedquerying.entities.Ingredient;
import com.example.advancedquerying.entities.Size;
import com.example.advancedquerying.service.IngredientService;
import com.example.advancedquerying.service.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.example.advancedquerying.message.PromptsMessage.*;

@Component
public class CommandRunner implements CommandLineRunner {
    Scanner scanner = new Scanner(System.in);
    private ShampooService shampooService;
    private IngredientService ingredientService;

    @Autowired
    public CommandRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    private Size size;
    private double price;
    private List<String> ingredientNames;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        System.out.println(ENTER_EXERCISE);
        int exNumber = Integer.parseInt(scanner.nextLine());

        switch (exNumber) {
            case 1:
                System.out.println(ENTER_SHAMPOO_SIZE);
                this.size = Size.valueOf(scanner.nextLine());
                this.shampooService.selectShampoosBySize(size)
                        .forEach(shampoo -> System.out.println(shampoo.giveBrandSizeAndPriceFormat()));
                break;
            case 2:
                System.out.println(ENTER_SHAMPOO_SIZE);
                this.size = Size.valueOf(scanner.nextLine());
                System.out.println(ENTER_LABEL_ID);
                Long labelId = Long.parseLong(scanner.nextLine());
                this.shampooService.selectShampooBySizeOrLabel(size, labelId)
                        .forEach(shampoo -> System.out.println(shampoo.giveBrandSizeAndPriceFormat()));
                break;
            case 3:
                System.out.println(ENTER_SHAMPOO_PRICE);
                this.price = Double.parseDouble(scanner.nextLine());
                this.shampooService.selectShampooByPrice(price)
                        .forEach(shampoo -> System.out.println(shampoo.giveBrandSizeAndPriceFormat()));
                break;
            case 4:
                System.out.println(ENTER_LETTER);
                char letter = scanner.nextLine().charAt(0);
                this.ingredientService.selectIngredientsByName(letter)
                        .forEach(ingredient -> System.out.println(ingredient.getName()));
                break;
            case 5:
                System.out.println(ENTER_INGREDIENT_NAMES);
                this.ingredientNames = Arrays.stream(scanner.nextLine().split("\\/")).toList();
                this.ingredientService.selectIngredientByNames(ingredientNames)
                        .forEach(ingredient -> System.out.println(ingredient.getName()));
                break;
            case 6:
                System.out.println(ENTER_SHAMPOO_PRICE);
                this.price = Double.parseDouble(scanner.nextLine());
                System.out.println(this.shampooService.countShampoosByPrice(price));
                break;
            case 7:
                System.out.println(ENTER_INGREDIENT_NAMES);
                this.ingredientNames = Arrays.stream(scanner.nextLine().split("\\/")).toList();
                this.shampooService.selectShampoosByIngredients(ingredientNames)
                        .forEach(shampoo -> System.out.println(shampoo.getBrand()));
                break;
            case 8:
                System.out.println(ENTER_INGREDIENT_COUNT);
                int ingredientCount = Integer.parseInt(scanner.nextLine());
                this.shampooService.selectShampoosByIngredientsCount(ingredientCount)
                        .forEach(shampoo -> System.out.println(shampoo.getBrand()));
                break;
            case 9:
                System.out.println(ENTER_INGREDIENT_NAME);
                String ingredientName = scanner.nextLine();
                Ingredient ingredient = this.ingredientService.getIngredientByName(ingredientName);
                removeIngredient(ingredientName, ingredient);
                break;
            case 10:
                this.ingredientService.updateIngredientsPriceBy10Percent();
                break;
            case 11:
                System.out.println(ENTER_INGREDIENT_NAMES);
                this.ingredientNames = Arrays.stream(scanner.nextLine().split("\\/")).toList();
                System.out.println(ENTER_PERCENT);
                double percent = Double.parseDouble(scanner.nextLine());
                int affectedRows = this.ingredientService.updatePriceOfIngredientsInList((percent), ingredientNames);
                System.out.printf("%d ingredients price was updated", affectedRows);
                break;
        }
    }

    //@Transactional
    void removeIngredient(String ingredientName, Ingredient ingredient) {
        // remove ingredient from shampoos
        this.shampooService.selectShampoosByIngredient(ingredient)
                .forEach(shampoo -> shampoo.getIngredients().remove(ingredient));
        // remove ingredient
      this.ingredientService.deleteIngredientsByName(ingredientName);
    }
}
