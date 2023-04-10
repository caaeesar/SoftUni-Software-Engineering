package Polymorphism.lab.WildFarm.animal;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),super.getAnimalName(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                super.getFoodEaten());
    }

}
