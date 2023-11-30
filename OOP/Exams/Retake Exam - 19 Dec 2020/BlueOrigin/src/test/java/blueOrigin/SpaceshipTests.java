package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {

    private static final String SPACESHIP_NAME = "Spaceship name";
    public static final String ASTRONAUT_NAME = "Astronaut name";
    private Spaceship spaceship;

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullShouldThrown() {
        this.spaceship = new Spaceship(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithBlankShouldThrown() {
        this.spaceship = new Spaceship("    ", 0);
    }

    @Test
    public void testConstructorWithValidName() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, 0);
        Assert.assertEquals(SPACESHIP_NAME, this.spaceship.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithLessThanZeroCapacityShouldThrown() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, -10);
    }

    @Test
    public void testConstructorWithZeroCapacity() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, 0);
        Assert.assertEquals(0, this.spaceship.getCapacity());
    }

    @Test
    public void testConstructorWithBiggerThanZeroCapacity() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, 10);
        Assert.assertEquals(10, this.spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithFullCapacityShouldThrown() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, 2);

        Astronaut first = new Astronaut(ASTRONAUT_NAME, 0);
        this.spaceship.add(first);
        Astronaut second = new Astronaut(ASTRONAUT_NAME, 0);
        this.spaceship.add(second);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithSpaceAndWithExistAstronautShouldThrown() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, 10);

        Astronaut first = new Astronaut(ASTRONAUT_NAME, 0);
        Astronaut second = new Astronaut(ASTRONAUT_NAME, 0);

        this.spaceship.add(first);
        this.spaceship.add(second);
        this.spaceship.add(first);
    }

    @Test
    public void testAddWithSpaceAndWithNonExistAstronautShouldAddedSuccessful() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, 3);

        Astronaut first = new Astronaut("First", 0);
        Astronaut second = new Astronaut("Second", 0);
        Astronaut third = new Astronaut("Third",0);

        this.spaceship.add(first);
        this.spaceship.add(second);
        this.spaceship.add(third);

        Assert.assertEquals(3,this.spaceship.getCount());
    }

    @Test
    public void testRemoveWithExistAstronautShouldRemovedSuccessful() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, 3);

        Astronaut astronaut = new Astronaut(ASTRONAUT_NAME, 0);
        Astronaut second = new Astronaut("Second", 0);
        Astronaut third = new Astronaut("Third",0);

        this.spaceship.add(astronaut);
        this.spaceship.add(second);
        this.spaceship.add(third);

        Assert.assertTrue(this.spaceship.remove(ASTRONAUT_NAME));
    }

    @Test
    public void testRemoveWithNonExistAstronaut() {
        this.spaceship = new Spaceship(SPACESHIP_NAME, 3);

        Astronaut first = new Astronaut("First", 0);
        Astronaut second = new Astronaut("Second", 0);
        Astronaut third = new Astronaut("Third",0);

        this.spaceship.add(first);
        this.spaceship.add(second);
        this.spaceship.add(third);

        Assert.assertFalse(this.spaceship.remove(ASTRONAUT_NAME));
    }



}
