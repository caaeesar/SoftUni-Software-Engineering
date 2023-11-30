package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetStoreTests {

    public static final String DEFAULT_ANIMAL_SPECIE = "Some specie";
    private Animal animal;
    private PetStore store;

    @Before
    public void setUp() {
        store = new PetStore();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWithNullShouldThrown() {
        store.addAnimal(null);
    }

    @Test
    public void testAddAnimalWithValidAnimalShouldBeSuccessfulAdded() {
        animal = new Animal("Some specie", 0, 0);
        store.addAnimal(animal);
        Assert.assertEquals(1, store.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms() {
        Animal first = new Animal("Some specie", 10, 0);
        Animal second = new Animal("Some specie", 20, 0);
        Animal third = new Animal("Some specie", 30, 0);
        Animal fourth = new Animal("Some specie", 5, 0);

        store.addAnimal(first);
        store.addAnimal(second);
        store.addAnimal(third);
        store.addAnimal(fourth);

        List<Animal> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);

        Assert.assertEquals(expected,store.findAllAnimalsWithMaxKilograms(5));
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        Animal first = new Animal("Some specie", 0, 5);
        Animal second = new Animal("Some specie", 0, 5);
        Animal mostExpensive = new Animal("Some specie", 0, 10);

        store.addAnimal(first);
        store.addAnimal(second);
        store.addAnimal(mostExpensive);

        Assert.assertEquals(mostExpensive,store.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAllAnimalBySpecie(){
        Animal first = new Animal(DEFAULT_ANIMAL_SPECIE, 0, 5);
        Animal second = new Animal(DEFAULT_ANIMAL_SPECIE, 0, 5);
        Animal third = new Animal("Other specie", 0, 10);

        store.addAnimal(first);
        store.addAnimal(second);
        store.addAnimal(third);

        List<Animal> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);

        Assert.assertEquals(expected,store.findAllAnimalBySpecie(DEFAULT_ANIMAL_SPECIE));
    }

    @Test
    public void testGetAnimals() {
        Animal first = new Animal(DEFAULT_ANIMAL_SPECIE, 0, 5);
        Animal second = new Animal(DEFAULT_ANIMAL_SPECIE, 0, 5);
        Animal third = new Animal("Other specie", 0, 10);

        store.addAnimal(first);
        store.addAnimal(second);
        store.addAnimal(third);

        List<Animal> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);

        Assert.assertEquals(expected,store.getAnimals());
    }

}

