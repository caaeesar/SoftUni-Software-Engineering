package Encapsulation.exercises.AnimalFarm;

public class Validators { // if we use same validation in other classes - we can create class with static methods

    public static void validateName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    public static void validateAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

}
