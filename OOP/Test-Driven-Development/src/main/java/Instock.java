import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> data;

    public Instock() {
        this.data = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public boolean contains(Product product) {
        for (Product p : this.data) {
            if (p.equals(product)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Product product) {
        if (this.data.contains(product)) return;
        this.data.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        boolean isFindProduct = false;
        for (Product currentProduct : this.data) {
            if (currentProduct.getLabel().equals(product)) {
                currentProduct.setQuantity(quantity);
                isFindProduct = true;
            }
        }
        if (!isFindProduct) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        if (index < 0 || index > this.data.size() - 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return this.data.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        for (Product currentProduct : this.data) {
            if (currentProduct.getLabel().equals(label)) {
                return currentProduct;
            }
        }
        throw new IllegalArgumentException("There is no such product!");
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count <= 0 || count > this.data.size()) {
            return new ArrayList<>();
        }
        return this.data.stream().limit(count).sorted(Comparator.naturalOrder()).toList();
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
       return this.data.stream().filter(p -> p.getPrice() > lo && p.getPrice() <= hi).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
       return this.data.stream().filter(p -> p.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > this.data.size()) {
            throw new IllegalArgumentException();
        }
        return this.data.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
       return this.data.stream().filter(p -> p.getQuantity() == quantity).collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
