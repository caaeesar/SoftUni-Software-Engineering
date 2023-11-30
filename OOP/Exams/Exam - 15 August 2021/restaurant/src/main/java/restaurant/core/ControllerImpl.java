package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Food;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private HealthFoodRepository<HealthyFood> foodRepo;
    private BeverageRepository<Beverages> beveragesRepo;
    private TableRepository<Table> tablesRepo;
    private double totalMoney = 0;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.foodRepo = healthFoodRepository;
        this.beveragesRepo = beverageRepository;
        this.tablesRepo = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = this.foodRepo.foodByName(name);
        if (food != null) {
            String msg = String.format(FOOD_EXIST, name);
            throw new IllegalArgumentException(msg);

        } else {
            switch (type) {
                case "Salad":
                    food = new Salad(name, price);
                    break;
                case "VeganBiscuits":
                    food = new VeganBiscuits(name, price);
                    break;
            }
            this.foodRepo.add(food);
            return String.format(FOOD_ADDED, name);
        }
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = this.beveragesRepo.beverageByName(name, brand);
        if (beverage != null) {
            String msg = String.format(BEVERAGE_EXIST, name);
            throw new IllegalArgumentException(msg);
        } else {
            switch (type) {
                case "Fresh":
                    beverage = new Fresh(name, counter, brand);
                    break;
                case "Smoothie":
                    beverage = new Smoothie(name, counter, brand);
                    break;
            }
            this.beveragesRepo.add(beverage);
            return String.format(BEVERAGE_ADDED, type, brand);
        }
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = this.tablesRepo.byNumber(tableNumber);
        if (table != null) {
            String msg = String.format(TABLE_IS_ALREADY_ADDED, tableNumber);
            throw new IllegalArgumentException(msg);
        } else {
            switch (type) {
                case "Indoors":
                    table = new Indoors(tableNumber, capacity);
                    break;
                case "InGarden":
                    table = new InGarden(tableNumber, capacity);
                    break;
            }
            this.tablesRepo.add(table);
            return String.format(TABLE_ADDED, tableNumber);
        }
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = this.tablesRepo.getAllEntities().stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst().orElse(null);
        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = this.tablesRepo.byNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        HealthyFood food = this.foodRepo.foodByName(healthyFoodName);
        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(food);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = this.tablesRepo.byNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        Beverages beverage = this.beveragesRepo.beverageByName(name, brand);
        if (beverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(beverage);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = this.tablesRepo.byNumber(tableNumber);
        double bill = table.bill();
        this.totalMoney += bill;
        table.clear();
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, this.totalMoney);
    }
}
