package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    protected BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return this.toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity <= this.cats.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        this.cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("%s %s:",this.name,this.getClass().getSimpleName())).append(System.lineSeparator());

        String catsNameOrNone = "";
        if (this.cats.isEmpty()) {
            catsNameOrNone = "none";
        } else {
            Collection<String> catsNames = this.cats.stream().map(Cat::getName).collect(Collectors.toList());
            catsNameOrNone = String.join(" ", catsNames);
        }

        statistics.append(String.format("Cats: %s",catsNameOrNone)).append(System.lineSeparator());
        statistics.append(String.format("Toys: %d Softness: %d",this.toys.size(),this.sumSoftness())).append(System.lineSeparator());

        return statistics.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(this.cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(this.toys);
    }
}
