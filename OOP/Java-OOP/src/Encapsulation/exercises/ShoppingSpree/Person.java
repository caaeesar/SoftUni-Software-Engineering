package Encapsulation.exercises.ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        Validators.validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validators.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (canBuy(product)) {
            this.products.add(product);
            this.money -= product.getCost();
        } else {
            throw new IllegalStateException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    private boolean canBuy(Product product) {
        return this.money >= product.getCost();
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    /*@Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.name).append(" – ");

        if (!this.solid.products.isEmpty()) {
            for (Encapsulation.exercise.ShoppingSpree.Product product : this.solid.products) {
                output.append(product.getName()).append(", ");
            }
            int lastIndexOfComma = output.toString().lastIndexOf(",");
            output.deleteCharAt(lastIndexOfComma);
        } else {
            output.append("Nothing bought");
        }
        return output.toString().trim();
    }*/
}
