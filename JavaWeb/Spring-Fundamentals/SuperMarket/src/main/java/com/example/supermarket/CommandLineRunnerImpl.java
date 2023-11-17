package com.example.supermarket;

import com.example.supermarket.model.dto.ProductViewDto;
import com.example.supermarket.model.dto.SellerViewDto;
import com.example.supermarket.model.entity.*;
import com.example.supermarket.repository.*;
import com.example.supermarket.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.example.supermarket.message.PromptMessage.*;
import static com.example.supermarket.message.SuccessfulMessage.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);
    private final ValidationUtil validationUtil;
    private final CategoryRepository categoryRepository;
    private final TownRepository townRepository;
    private final ShopRepository shopRepository;
    private final SellerRepository sellerRepository;

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CommandLineRunnerImpl(ValidationUtil validationUtil, CategoryRepository categoryRepository, TownRepository townRepository, ShopRepository shopRepository, SellerRepository sellerRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.categoryRepository = categoryRepository;
        this.townRepository = townRepository;
        this.shopRepository = shopRepository;
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("""
                Hi
                Choose option from:
                1 - for Add Category
                2 - for Add Town
                3 - for Add Shop
                4 - for Add Seller
                5 - for Add Product
                6 - for Set seller new manager
                7 - for Distributing product in shop
                8 - for Showing all sellers in Shop
                9 - for Showing all products in Shop
                """);
        int option = Integer.parseInt(scanner.nextLine());

        String townName;
        String shopName;
        String categoryName;
        String firstName;
        String lastName;
        while (true) {
            // todo: refactoring switch
            switch (option) {
                case 1:
                    System.out.println(ENTER_CATEGORY_NAME);
                    categoryName = scanner.nextLine();
                    Category category = new Category(categoryName);
                    if (!validationUtil.isValid(category)) {
                        System.out.println(validationUtil.constraint(category).stream().findFirst().get().getMessage());
                        option = Integer.parseInt(scanner.nextLine());
                        continue;
                    }
                    categoryRepository.save(category);
                    System.out.println(SUCCESSFUL_ADDED_CATEGORY);
                    break;
                case 2:
                    System.out.println(ENTER_TOWN_NAME);
                    townName = scanner.nextLine();
                    Town town = new Town(townName);
                    townRepository.save(town);
                    System.out.println(SUCCESSFUL_ADDED_TOWN);
                    break;
                case 3:
                    System.out.println(ENTER_SHOP);
                    String shopInfo = scanner.nextLine();
                    shopName = shopInfo.split(" ")[0];
                    String address = shopInfo.split(" ")[1];
                    townName = shopInfo.split(" ")[2];
                    Shop shop = new Shop(address, shopName, townRepository.getTownByName(townName));
                    shopRepository.save(shop);
                    System.out.println(SUCCESSFUL_ADDED_SHOP);
                    break;
                case 4:
                    System.out.println(ENTER_SELLER);
                    String sellerInfo = scanner.nextLine();
                    firstName = sellerInfo.split(" ")[0];
                    lastName = sellerInfo.split(" ")[1];
                    int age = Integer.parseInt(sellerInfo.split(" ")[2]);
                    BigDecimal salary = BigDecimal.valueOf(Double.parseDouble(sellerInfo.split(" ")[3]));
                    shopName = sellerInfo.split(" ")[4];
                    Seller seller = new Seller(firstName, lastName, age, salary, shopRepository.getShopByName(shopName));
                    if (!validationUtil.isValid(seller)) {
                        System.out.println(validationUtil.constraint(seller).stream().findFirst().get().getMessage());
                        option = Integer.parseInt(scanner.nextLine());
                        continue;
                    }
                    sellerRepository.save(seller);
                    System.out.println(SUCCESSFUL_ADDED_SELLER);
                    break;
                case 5:
                    System.out.println(ENTER_PRODUCT);
                    String productInfo = scanner.nextLine();
                    String name = productInfo.split(" ")[0];
                    BigDecimal price = BigDecimal.valueOf(Double.parseDouble(productInfo.split(" ")[1]));
                    LocalDate bestBefore = LocalDate.parse(productInfo.split(" ")[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    categoryName = productInfo.split(" ")[3];
                    Product product = new Product(bestBefore, name, price, categoryRepository.getCategoryByName(categoryName));
                    if (!validationUtil.isValid(product)) {
                        System.out.println(validationUtil.constraint(product).stream().findFirst().get().getMessage());
                        option = Integer.parseInt(scanner.nextLine());
                        continue;
                    }
                    productRepository.save(product);
                    System.out.println(SUCCESSFUL_ADDED_PRODUCT);
                    break;
                case 6:
                    System.out.println(ENTER_SELLER_NAMES);
                    String sellersNames = scanner.nextLine();
                    firstName = sellersNames.split(" ")[0];
                    lastName = sellersNames.split(" ")[1];
                    Seller seller1 = sellerRepository.getSellerByFirstNameAndLastName(firstName, lastName);

                    System.out.println(ENTER_MANAGER);
                    String managerInfo = scanner.nextLine();
                    firstName = managerInfo.split(" ")[0];
                    lastName = managerInfo.split(" ")[1];
                    age = Integer.parseInt(managerInfo.split(" ")[2]);
                    salary = BigDecimal.valueOf(Double.parseDouble(managerInfo.split(" ")[3]));
                    Seller manager = new Seller(firstName, lastName, age, salary, seller1.getShop());

                    sellerRepository.save(manager);
                    seller1.setManager(manager);
                    sellerRepository.save(seller1);
                    System.out.println(SUCCESSFUL_ADDED_MANAGER);
                    break;
                case 7:
                    System.out.println(ENTER_PRODUCT_NAME);
                    String productName = scanner.nextLine();
                    Product product1 = productRepository.getProductByName(productName);

                    System.out.println(ENTER_PRODUCT_DISTRIBUTION);
                    List<String> shopNames = Arrays.stream(scanner.nextLine().split(" ")).toList();
                    List<Shop> shops = findShopsByShopName(shopNames);
                    distributionProductToShops(shops, product1,shopRepository, productRepository);
                    System.out.println(SUCCESSFUL_ADDED_PRODUCT_DISTRIBUTION);
                    break;
                case 8:
                    System.out.println(ENTER_SHOP_NAME);
                    shopName = scanner.nextLine();
                    sellerRepository.getSellersByShop_NameOrderByFirstNameAsc(shopName)
                            .stream()
                            .map(s -> modelMapper.map(s, SellerViewDto.class))
                            .forEach(sellerViewDto -> System.out.println(sellerViewDto.toString()));
                    break;
                case 9:
                    System.out.println(ENTER_SHOP_NAME);
                    shopRepository.getShopByName(scanner.nextLine()).getProducts()
                            .stream()
                            .map(p -> modelMapper.map(p, ProductViewDto.class))
                            .forEach(p -> System.out.println(p.toString()));
                    break;
            }
            option = Integer.parseInt(scanner.nextLine());
        }
    }

    private static void distributionProductToShops(List<Shop> shops, Product product, ShopRepository shopRepository, ProductRepository productRepository) {
        for (Shop shop : shops) {
            shop.getProducts().add(product);
            product.getShops().add(shop);
            shopRepository.save(shop);
            productRepository.save(product);
        }
    }

    private List<Shop> findShopsByShopName(List<String> shopNames) {
        List<Shop> shops = new ArrayList<>();
        for (String sName : shopNames) {
            shops.add(shopRepository.getShopByName(sName));
        }
        return shops;
    }
}
