package others.animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] arguments) {

        Animal dog = new Dog(3, "Bharo", "m");
        Animal cat = new Cat(4, "Aae", "f");
        Animal kitten = new Kitten(1, "Cvcs", "f");
        Animal frog = new Frog(10, "Aff", "f");

        List<Animal> animalList = new ArrayList<>();
        animalList.add(dog);
        animalList.add(cat);
        animalList.add(kitten);
        animalList.add(frog);

        animalList.stream()
                .sorted(Comparator.comparing(a -> a.name))
                .forEach(System.out::println);
    }
}
