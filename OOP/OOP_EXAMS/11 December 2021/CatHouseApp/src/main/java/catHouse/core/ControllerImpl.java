package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.Repository;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        this.houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);
        if (toy == null) {
            String msg = String.format(NO_TOY_FOUND, toyType);
            throw new IllegalArgumentException(msg);
        }

        House house = this.houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
        house.buyToy(toy);
        this.toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = this.houses.stream()
                .filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);

        boolean canLiveInHouse = (cat.getClass().getSimpleName().equals("ShorthairCat") && house.getClass().getSimpleName().equals("ShortHouse")) ||
                (cat.getClass().getSimpleName().equals("LonghairCat") && house.getClass().getSimpleName().equals("LongHouse"));

        if (canLiveInHouse) {
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, cat.getClass().getSimpleName(), houseName);
        }

        return UNSUITABLE_HOUSE;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses
                .stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);

        house.getCats().forEach(Cat::eating);
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses
                .stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);

        Collection<Cat> cats = house.getCats();
        double totalCatsPrice = cats.stream().mapToDouble(Cat::getPrice).sum();

        Collection<Toy> toys = house.getToys();
        double totalToysPrice = toys.stream().mapToDouble(Toy::getPrice).sum();

        return String.format(VALUE_HOUSE, houseName, totalCatsPrice + totalToysPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        for (House house : this.houses) {
            out.append(house.getStatistics()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
