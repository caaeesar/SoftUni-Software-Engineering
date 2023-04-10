package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.Collection;
import java.util.LinkedList;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {

    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new LinkedList<>();
        this.beverages = new LinkedList<>();
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        this.allPeople = this.numberOfPeople * this.pricePerPerson;
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReservedTable = true;
        this.setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double totalFoodPRice = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double totalDrinksPrice = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();
        return totalFoodPRice + totalDrinksPrice + allPeople();
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("Table - %d",this.number)).append(System.lineSeparator());
        info.append(String.format("Size - %d",this.size)).append(System.lineSeparator());
        info.append(String.format("Type - %s",this.getClass().getSimpleName())).append(System.lineSeparator());
        info.append(String.format("All price - %.2f",this.pricePerPerson)).append(System.lineSeparator());
        return info.toString().trim();
    }
}
