package Polymorphism.lab.WildFarm.animal;

public abstract class Felime extends Mammal {

    private String breed;

    protected Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    public String getBreed() {
        return breed;
    }

}
