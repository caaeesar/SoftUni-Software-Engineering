package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {

    public static final String DEFAULT_ANIMAL_TYPE = "Animal type";
    private Farm farm;
    private static final String DEFAULT_FARM_NAME = "Farm name";
    private static final int ZERO_CAPACITY = 0;

    private Animal animal;

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullNameShouldThrown() {
        farm = new Farm(null, 0);
    }

    @Test
    public void testConstructorWithValidName() {
        farm = new Farm(DEFAULT_FARM_NAME, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithLessThanZeroCapacityShouldThrown() {
        farm = new Farm(DEFAULT_FARM_NAME, ZERO_CAPACITY - 1);
    }

    @Test
    public void testConstructorWithZeroCapacity() {
        farm = new Farm(DEFAULT_FARM_NAME, ZERO_CAPACITY);
    }

    @Test
    public void testConstructorWithBiggerThanZeroCapacity() {
        farm = new Farm(DEFAULT_FARM_NAME, ZERO_CAPACITY + 10);
        Assert.assertEquals(10, farm.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithoutMoreSpaceShouldThrown() {
        animal = new Animal(DEFAULT_ANIMAL_TYPE, 0);

        farm = new Farm(DEFAULT_FARM_NAME, 1);
        farm.add(animal);

        Animal second = new Animal(DEFAULT_ANIMAL_TYPE, 0);
        farm.add(second);
    }

    @Test
    public void testAddWithFreeSpaceAndNewAnimalShouldBeAddedSuccessful() {
        animal = new Animal(DEFAULT_ANIMAL_TYPE, 0);

        farm = new Farm(DEFAULT_FARM_NAME, 2);
        farm.add(animal);

        Animal second = new Animal("Second", 0);
        farm.add(second);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithFreeSpaceAndExistAnimalShouldThrown() {
        animal = new Animal(DEFAULT_ANIMAL_TYPE, 0);

        farm = new Farm(DEFAULT_FARM_NAME, 2);
        farm.add(animal);

        Animal second = new Animal(DEFAULT_ANIMAL_TYPE, 0);
        farm.add(second);
    }

    @Test
    public void testRemoveWithExistAnimal() {
        animal = new Animal(DEFAULT_ANIMAL_TYPE, 0);
        Animal first = new Animal("First", 0);
        Animal second = new Animal("Second", 0);

        farm = new Farm(DEFAULT_FARM_NAME, 10);
        farm.add(animal);
        farm.add(first);
        farm.add(second);

        Assert.assertTrue(farm.remove(DEFAULT_ANIMAL_TYPE));
    }

    @Test
    public void testRemoveWithNonExistAnimal() {
        Animal first = new Animal("First", 0);
        Animal second = new Animal("Second", 0);
        Animal third = new Animal("Third", 0);

        farm = new Farm(DEFAULT_FARM_NAME, 10);
        farm.add(first);
        farm.add(second);
        farm.add(third);

        Assert.assertFalse(farm.remove(DEFAULT_ANIMAL_TYPE));
    }

    @Test
    public void testGetCount() {
        Animal first = new Animal("First", 0);
        Animal second = new Animal("Second", 0);
        Animal third = new Animal("Third", 0);

        farm = new Farm(DEFAULT_FARM_NAME, 10);
        farm.add(first);
        farm.add(second);
        farm.add(third);

        Assert.assertEquals(3,farm.getCount());
    }

    @Test
    public void testGetName() {
        farm = new Farm(DEFAULT_FARM_NAME,0);
        Assert.assertEquals(DEFAULT_FARM_NAME,farm.getName());
    }


}
