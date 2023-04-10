package others.animal;

public class Dog extends Animal {

    public Dog(int age, String name, String gender) {
        super(age, name, gender);
    }

    @Override
    String makeNoise() {
        return "Bark";
    }
}
