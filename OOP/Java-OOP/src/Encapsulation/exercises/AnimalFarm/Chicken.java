package Encapsulation.exercises.AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        Validators.validateName(name);
        this.name = name;
    }

    private void setAge(int age) {
        Validators.validateAge(age);
        this.age = age;
    }

    private double calculateProductPerDay() {
        if (this.age <= 5) {
            return 2.00;
        } else if (this.age <= 11) {
            return 1.00;
        }
        return 0.75;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Encapsulation.exercise.AnimalFarm.Chicken %s (age %d) can produce %.2f eggs per day."
                , this.name, this.age, this.productPerDay());
    }
}
