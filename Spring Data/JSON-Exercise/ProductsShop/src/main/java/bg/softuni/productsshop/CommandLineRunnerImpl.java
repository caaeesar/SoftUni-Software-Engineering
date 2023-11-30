package bg.softuni.productsshop;

import bg.softuni.productsshop.service.CategoryService;
import bg.softuni.productsshop.service.ProductService;
import bg.softuni.productsshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public CommandLineRunnerImpl(UserService userService, ProductService productService, CategoryService categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Enter exercise number:");
        int exNum = Integer.parseInt(scanner.nextLine());
        switch (exNum) {
            case 1 -> this.productService.findProductsInRange500To1000();
            case 2 -> this.userService.findUsersWithSuccessfullySoldProducts();
            case 3 -> this.categoryService.findCategoriesByProductsCount();
            case 4 -> this.userService.findUsersAndProductsInfo();
        }
    }

    private void seedData() throws IOException {
        this.userService.seedUsers();
        this.categoryService.seedCategories();
        this.productService.seedProducts();
    }
}
