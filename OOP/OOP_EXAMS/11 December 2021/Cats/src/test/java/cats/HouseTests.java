package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    public static final String DEFAULT_HOUSE_NAME = "Some house name";
    public static final String DEFAULT_CAT_NAME = "Some cat name";
    private House house;

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullNameShouldThrown() {
        house = new House(null,0);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithBlankNameShouldThrown() {
        house = new House("     ",0);
    }

    @Test
    public void testConstructorWithValidName() {
        house = new House(DEFAULT_HOUSE_NAME,0);
        Assert.assertEquals(DEFAULT_HOUSE_NAME,house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithLessThanZeroCapacityShouldThrown() {
        house = new House(DEFAULT_HOUSE_NAME, -1);
    }

    @Test
    public void testConstructorWithZeroCapacityShouldBeValid() {
        house = new House(DEFAULT_HOUSE_NAME, 0);
        Assert.assertEquals(0,house.getCapacity());
    }

    @Test
    public void testConstructorWithMoreThanZeroCapacityShouldBeValid() {
        house = new House(DEFAULT_HOUSE_NAME, 5);
        Assert.assertEquals(5,house.getCapacity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddCatWithoutMoreSpaceShouldThrow() {
        Cat first = new Cat(DEFAULT_CAT_NAME);
        Cat second = new Cat(DEFAULT_CAT_NAME);

        house = new House(DEFAULT_HOUSE_NAME,1);
        house.addCat(first);
        house.addCat(second);
    }

    @Test
    public void testAddCatWithSpaceShouldAddedSuccessful() {
        Cat first = new Cat(DEFAULT_CAT_NAME);
        Cat second = new Cat(DEFAULT_CAT_NAME);

        house = new House(DEFAULT_HOUSE_NAME,5);
        house.addCat(first);
        house.addCat(second);

        Assert.assertEquals(2,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatWithNonExistCatShouldThrow() {
        Cat cat = new Cat(DEFAULT_CAT_NAME);
        house = new House(DEFAULT_HOUSE_NAME,5);
        house.addCat(cat);

        house.removeCat("invalid cat");
    }

    @Test
    public void testRemoveCatWithExistCatShouldRemoveSuccessful() {
        Cat cat = new Cat(DEFAULT_CAT_NAME);
        house = new House(DEFAULT_HOUSE_NAME,5);
        house.addCat(cat);

        house.removeCat(DEFAULT_CAT_NAME);
        Assert.assertEquals(0,house.getCount());
    }

    @Test
    public void testCatForSaleWithExistCat() {
        Cat cat = new Cat(DEFAULT_CAT_NAME);
        house = new House(DEFAULT_HOUSE_NAME,5);
        house.addCat(cat);
        Assert.assertEquals(cat,house.catForSale(DEFAULT_CAT_NAME));
        Assert.assertFalse(cat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleWithNonExistCat() {
        Cat cat = new Cat(DEFAULT_CAT_NAME);
        house = new House(DEFAULT_HOUSE_NAME,5);
        house.addCat(cat);

        Assert.assertNull(house.catForSale("invalid name"));
    }

    @Test
    public void testStatistics() {
        Cat first = new Cat(DEFAULT_CAT_NAME);
        Cat second = new Cat(DEFAULT_CAT_NAME);

        house = new House(DEFAULT_HOUSE_NAME,5);
        house.addCat(first);
        house.addCat(second);

        String catsNames = DEFAULT_CAT_NAME + ", " + DEFAULT_CAT_NAME;
        String expected = String.format("The cat %s is in the house %s!",catsNames,DEFAULT_HOUSE_NAME);
        Assert.assertEquals(expected,house.statistics());
    }

    @Test
    public void testGetCapacity() {
        house = new House(DEFAULT_HOUSE_NAME,5);
        Assert.assertEquals(5,house.getCapacity());
    }

}
