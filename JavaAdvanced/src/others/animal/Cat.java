package others.animal;

public class Cat extends Animal {

    protected Cat(int age, String name, String gender) {
        super(age, name, gender);
    }

    @Override
    String makeNoise() {
        return "Meaow";

    }
}
