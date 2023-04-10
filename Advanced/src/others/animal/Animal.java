package others.animal;

public abstract class Animal /*implements Comparable<Animal>*/{

    int age;
    String name;
    String gender;

    protected Animal(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    abstract String makeNoise();

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.makeNoise());
    }

  /*  @Override
    public int compareTo(Animal others.animal) {
        return others.animal.name.compareTo(this.name);
    }*/
}
