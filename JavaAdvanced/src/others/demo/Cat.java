package others.demo;

public class Cat {
    private String name;

    public Cat(String name) throws IllegalAccessException {
        this.setName(name);
    }

    public void setName(String name) throws IllegalAccessException {
        if (name.length() == 3) {
            this.name = name;
        } else {
            throw new IllegalAccessException("dscs");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
