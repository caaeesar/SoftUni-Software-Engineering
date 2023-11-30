package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(this.animals);
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(this.foods);
    }

    @Override
    public int sumCalories() {
        return this.foods.stream().mapToInt(Food::getCalories).sum();

    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.capacity <= this.animals.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : this.animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s (%s):", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());

        String animalsOrNone = "";
        if (this.animals.isEmpty()) {
            animalsOrNone = "none";
        } else {
            List<String> animalsNames = this.animals.stream().map(Animal::getName).collect(Collectors.toList());
            animalsOrNone = String.join(" ",animalsNames);
        }

        info.append(String.format("Animals: %s",animalsOrNone)).append(System.lineSeparator());
        info.append(String.format("Foods: %d",this.foods.size())).append(System.lineSeparator());

        int totalCalories = this.foods.stream().mapToInt(Food::getCalories).sum();
        info.append(String.format("Calories: %d",totalCalories)).append(System.lineSeparator());

        return info.toString().trim();
    }
}
