package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {

    public static final String AQUARIUM_NAME = "aquarium name";
    public static final String FISH_NAME = "fish name";
    private Aquarium aquarium;
    private Fish fish;

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullShouldThrown() {
        aquarium = new Aquarium(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithBlankShouldThrown() {
        aquarium = new Aquarium("    ", 0);
    }

    @Test
    public void testConstructorWithValidName() {
        aquarium = new Aquarium(AQUARIUM_NAME, 0);
        Assert.assertEquals(AQUARIUM_NAME, aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithLessThanZeroCapacityShouldThrown() {
        aquarium = new Aquarium(AQUARIUM_NAME, -1);
    }

    @Test
    public void testConstructorWithExactlyZeroCapacity() {
        aquarium = new Aquarium(AQUARIUM_NAME, 0);
        Assert.assertEquals(0, aquarium.getCapacity());
    }

    @Test
    public void testConstructorWithMoreThanZeroCapacity() {
        aquarium = new Aquarium(AQUARIUM_NAME, 10);
        Assert.assertEquals(10, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithoutCapacityShouldThrown() {
        aquarium = new Aquarium(AQUARIUM_NAME, 2);
        Fish first = new Fish(FISH_NAME);
        Fish second = new Fish(FISH_NAME);
        Fish third = new Fish(FISH_NAME);

        aquarium.add(first);
        aquarium.add(second);
        aquarium.add(third);
    }

    @Test
    public void testAddWithMoreFreeCapacityShouldAddedSuccessful() {
        aquarium = new Aquarium(AQUARIUM_NAME, 3);
        Fish first = new Fish(FISH_NAME);
        Fish second = new Fish(FISH_NAME);
        Fish third = new Fish(FISH_NAME);

        aquarium.add(first);
        aquarium.add(second);
        aquarium.add(third);

        Assert.assertEquals(3, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWithNonExistFishShouldThrown() {
        fish = new Fish(FISH_NAME);
        aquarium = new Aquarium(AQUARIUM_NAME, 1);
        aquarium.add(fish);
        aquarium.remove("non exist fish name");
    }

    @Test
    public void testRemoveWithExistFishShouldRemovedSuccessful() {
        aquarium = new Aquarium(AQUARIUM_NAME,10);
        fish = new Fish(FISH_NAME);
        Fish otherFish = new Fish("Other fish name");
        aquarium.add(fish);
        aquarium.add(otherFish);

        aquarium.remove(FISH_NAME);

        Assert.assertEquals(1,aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishWithNonExistFishShouldThrown() {
        aquarium = new Aquarium(AQUARIUM_NAME,10);
        fish = new Fish(FISH_NAME);
        Fish otherFish = new Fish("Other fish name");
        aquarium.add(fish);
        aquarium.add(otherFish);

        aquarium.sellFish("non exist fish name");
    }

    @Test
    public void testSellFishWithExistFish() {
        aquarium = new Aquarium(AQUARIUM_NAME,10);
        fish = new Fish(FISH_NAME);
        Fish otherFish = new Fish("Other fish name");
        aquarium.add(fish);
        aquarium.add(otherFish);

        aquarium.sellFish(FISH_NAME);
        Assert.assertFalse(aquarium.sellFish(FISH_NAME).isAvailable());
    }

}

