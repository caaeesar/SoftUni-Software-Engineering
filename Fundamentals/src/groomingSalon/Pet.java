package groomingSalon;

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        return String.format("%s %d - (%s)",this.name, this.age, this.owner);
    }
}
