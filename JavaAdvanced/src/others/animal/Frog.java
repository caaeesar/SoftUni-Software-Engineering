package others.animal;

public class Frog extends Animal{

    protected Frog(int age, String name, String gender) {
        super(age, name, gender);
    }

    @Override
    String makeNoise() {
        return "Kwac";
    }
}
