package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {

    public static final String DEFAULT_CAR_BRAND = "brand";
    private Car car = new Car(DEFAULT_CAR_BRAND,0,0);
    private Garage garage;

    @Before
    public void setUp() {
        garage = new Garage();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarWithNullValueShouldThrown() {
        garage.addCar(null);
    }

    @Test
    public void testAddCarWithValidCarShouldSuccessfulAdded() {
        garage.addCar(car);
        Assert.assertEquals(1,garage.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAbove() {
        Car first = new Car(DEFAULT_CAR_BRAND,20,0);
        Car second = new Car(DEFAULT_CAR_BRAND,40,0);
        Car third = new Car(DEFAULT_CAR_BRAND,50,0);

        garage.addCar(first);
        garage.addCar(second);
        garage.addCar(third);

        List<Car> expected = new ArrayList<>();
        expected.add(second);
        expected.add(third);
        int speed = 20;

        Assert.assertEquals(expected,garage.findAllCarsWithMaxSpeedAbove(speed));
    }

    @Test
    public void testGetTheMostExpensiveCar() {
        Car first = new Car(DEFAULT_CAR_BRAND,0,10);
        Car second = new Car(DEFAULT_CAR_BRAND,0,20);
        Car third = new Car(DEFAULT_CAR_BRAND,0,30);

        garage.addCar(first);
        garage.addCar(second);
        garage.addCar(third);

        Assert.assertEquals(third,garage.getTheMostExpensiveCar());
    }

    @Test
    public void testFindAllCarsByBrand() {
        Car first = new Car(DEFAULT_CAR_BRAND,20,0);
        Car second = new Car(DEFAULT_CAR_BRAND,40,0);
        Car third = new Car(DEFAULT_CAR_BRAND,50,0);

        garage.addCar(first);
        garage.addCar(second);
        garage.addCar(third);

        List<Car> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);

        Assert.assertEquals(expected,garage.findAllCarsByBrand(DEFAULT_CAR_BRAND));
    }

    @Test
    public void testGetCars() {

        Car first = new Car(DEFAULT_CAR_BRAND,20,0);
        Car second = new Car(DEFAULT_CAR_BRAND,40,0);
        Car third = new Car(DEFAULT_CAR_BRAND,50,0);

        garage.addCar(first);
        garage.addCar(second);
        garage.addCar(third);

        List<Car> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);

        Assert.assertEquals(expected,garage.getCars());
    }

}