package Encapsulation.exercises.ShoppingSpree;

import java.util.*;// todo 90/100
import java.util.stream.Collectors;

public class Main {

    public static final String END = "END";

    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        String[] peopleData = Arrays.stream(scanner.nextLine().split(";")).toArray(String[]::new);
        String[] productsData = Arrays.stream(scanner.nextLine().split(";")).toArray(String[]::new);
        List<Person> allPeople;
        List<Product> allProduct;
        try {
            allPeople = getAllPeople(peopleData);
            allProduct = getAllProducts(productsData);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String input = scanner.nextLine();
        Person person = null;
        Product product = null;
        while (!END.equals(input)) {

            String[] parts = input.split("\\s+");
            String personName = parts[0];
            String productName = parts[1];

            Optional<Person> optionalPerson = allPeople.stream().filter(p -> p.getName().equals(personName)).findFirst();
            Optional<Product> optionalProduct = allProduct.stream().filter(p -> p.getName().equals(productName)).findFirst();

            if (optionalPerson.isPresent()) {
                person = optionalPerson.get();
            }
            if (optionalProduct.isPresent()) {
                product = optionalProduct.get();
            }

            try {
                if (person != null && product != null) {
                    person.buyProduct(product);
                    System.out.printf("%s bought %s\n", person.getName(), product.getName());
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
        for (Person currentPerson : allPeople) {

            List<Product> personProducts = currentPerson.getProducts();
            if (personProducts.isEmpty()) {
                System.out.printf("%s - Nothing bought",currentPerson.getName());
            } else {
             List<String>  productsName = personProducts
                     .stream()
                     .map(Product::getName)
                     .collect(Collectors.toList());
             System.out.println(currentPerson.getName() + " - " + String.join(", ",productsName));
            }
        }
    }

    private static List<Product> getAllProducts(String[] productsData) {
        List<Product> allProducts = new ArrayList<>();
        for (int i = 0; i < productsData.length; i++) {

            String[] productsTokens = productsData[i].split("=");
            String name = productsTokens[0];
            double cost = Double.parseDouble(productsTokens[1]);
            Product product = new Product(name, cost);
            allProducts.add(product);
        }
        return allProducts;
    }

    private static List<Person> getAllPeople(String[] peopleData) {
        List<Person> allPeople = new ArrayList<>();
        for (int i = 0; i < peopleData.length; i++) {

            String[] peopleTokens = peopleData[i].split("=");
            String name = peopleTokens[0];
            double money = Double.parseDouble(peopleTokens[1]);
            Person person = new Person(name, money);
            allPeople.add(person);
        }
        return allPeople;
    }
}
