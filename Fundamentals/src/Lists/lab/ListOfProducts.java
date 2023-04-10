package Lists.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] arguments) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            products.add(scanner.nextLine());
        }
        Collections.sort(products);
        int number = 1;
        for (String currentProduct : products) {
            System.out.printf("%d.%s%n", number, currentProduct);
            number++;
        }
    }
}
