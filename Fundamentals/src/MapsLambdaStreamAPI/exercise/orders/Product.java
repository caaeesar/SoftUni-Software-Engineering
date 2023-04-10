package MapsLambdaStreamAPI.exercise.orders;

public class Product {
    private String name;
    private double price;
    private int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }


    @Override
    public String toString() {
        return String.format("%s -> %.2f", this.name, this.getTotalPrice());
    }
}
