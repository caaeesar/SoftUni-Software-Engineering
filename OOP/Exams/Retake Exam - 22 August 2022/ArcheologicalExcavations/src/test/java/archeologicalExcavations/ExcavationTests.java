package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {

    private static final int ZERO_CAPACITY = 0;
    public static final String EXCAVATION_NAME = "Some name";

    private Excavation defaultExcavation;

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullNameShouldThrow() {
        defaultExcavation = new Excavation(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithBlankNameShouldThrow() {
        defaultExcavation = new Excavation("     ", 0);
    }

    @Test
    public void testConstructorWithValidName() {
        Excavation defaultExcavation = new Excavation(EXCAVATION_NAME, 0);
        Assert.assertEquals(EXCAVATION_NAME, defaultExcavation.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithSmallerThanZeroCapacityShouldThrow() {
        defaultExcavation = new Excavation(EXCAVATION_NAME, ZERO_CAPACITY - 1);
    }

    @Test
    public void testConstructorWithZeroCapacityShouldBeValid() {
        defaultExcavation = new Excavation(EXCAVATION_NAME, ZERO_CAPACITY);
        Assert.assertEquals(ZERO_CAPACITY, defaultExcavation.getCapacity());
    }

    @Test
    public void testConstructorWithBiggerThanZeroCapacityShouldBeValid() {
        defaultExcavation = new Excavation(EXCAVATION_NAME, ZERO_CAPACITY + 10);
        Assert.assertEquals(10, defaultExcavation.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistWithFullCapacityShouldThrow() {
        Archaeologist first = new Archaeologist("First", 0);
        Archaeologist second = new Archaeologist("Second", 0);
        Archaeologist third = new Archaeologist("Third", 0);

        defaultExcavation = new Excavation(EXCAVATION_NAME, 2);
        defaultExcavation.addArchaeologist(first);
        defaultExcavation.addArchaeologist(second);
        defaultExcavation.addArchaeologist(third);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologistWithExistArchaeologistShouldThrow() {
        Archaeologist first = new Archaeologist("First", 0);

        defaultExcavation = new Excavation(EXCAVATION_NAME, 3);
        defaultExcavation.addArchaeologist(first);
        defaultExcavation.addArchaeologist(first);
    }

    @Test
    public void testGetCountWithNonExistArchaeologistShouldAddedSuccessful() {
        Archaeologist first = new Archaeologist("First", 0);
        Archaeologist second = new Archaeologist("Second", 0);
        Archaeologist third = new Archaeologist("Third", 0);

        defaultExcavation = new Excavation(EXCAVATION_NAME, 3);
        defaultExcavation.addArchaeologist(first);
        defaultExcavation.addArchaeologist(second);
        defaultExcavation.addArchaeologist(third);

        Assert.assertEquals(3, defaultExcavation.getCount());
    }

    @Test
    public void testRemoveArchaeologistWithExistArchaeologistShouldReturnTrue() {
        Archaeologist first = new Archaeologist("First", 0);
        Archaeologist second = new Archaeologist("Second", 0);
        Archaeologist third = new Archaeologist("Third", 0);

        defaultExcavation = new Excavation(EXCAVATION_NAME, 3);
        defaultExcavation.addArchaeologist(first);
        defaultExcavation.addArchaeologist(second);
        defaultExcavation.addArchaeologist(third);

        Assert.assertTrue(defaultExcavation.removeArchaeologist(first.getName()));
    }

    @Test
    public void testRemoveArchaeologistWithNonExistArchaeologistShouldReturnFalse() {
        Archaeologist first = new Archaeologist("First", 0);
        Archaeologist second = new Archaeologist("Second", 0);
        Archaeologist third = new Archaeologist("Third", 0);

        defaultExcavation = new Excavation(EXCAVATION_NAME, 3);
        defaultExcavation.addArchaeologist(first);
        defaultExcavation.addArchaeologist(second);
        defaultExcavation.addArchaeologist(third);

        Assert.assertFalse(defaultExcavation.removeArchaeologist("Some name"));
    }

}
