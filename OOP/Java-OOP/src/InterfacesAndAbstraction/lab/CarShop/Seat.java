package InterfacesAndAbstraction.lab.CarShop;

public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString()).append(System.lineSeparator());
        output.append(String.format("%s sells for %f", this.getModel(), this.price));
        return output.toString();
    }
}
