package others.humans;

// super class | base class | parent class
public class Human {
    String name;
    String surname;

    // protected constructor ->
    // visible for subclasses and not to be creating instance from this class
    protected Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "name = " + name + ", surname = " + surname;
    }
}
