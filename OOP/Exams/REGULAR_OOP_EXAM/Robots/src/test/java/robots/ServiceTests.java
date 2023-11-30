package robots;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTests {

    public static final String SERVICE_NAME = "Service name";
    public static final String ROBOT_NAME = "Robot name";
    private Service service;

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithLessThanZeroCapacityShouldThrown() {
        this.service = new Service(SERVICE_NAME, -10);
    }

    @Test
    public void testConstructorWithExactlyZeroCapacity() {
        this.service = new Service(SERVICE_NAME, 0);
        Assert.assertEquals(0, this.service.getCapacity());
    }

    @Test
    public void testConstructorWithMoreThanZeroCapacity() {
        this.service = new Service(SERVICE_NAME, 10);
        Assert.assertEquals(10, this.service.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullShouldThrown() {
        this.service = new Service(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithBlankShouldThrown() {
        this.service = new Service("    ", 0);
    }

    @Test
    public void testConstructorWithValidName() {
        this.service = new Service(SERVICE_NAME, 0);
        Assert.assertEquals(SERVICE_NAME, this.service.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithFullServiceShouldThrown() {
        Robot first = new Robot(ROBOT_NAME);
        Robot second = new Robot(ROBOT_NAME);
        Robot third = new Robot(ROBOT_NAME);
        Robot four = new Robot(ROBOT_NAME);
        this.service = new Service(SERVICE_NAME, 3);

        this.service.add(first);
        this.service.add(second);
        this.service.add(third);
        this.service.add(four);
    }

    @Test
    public void testAddWithFreeCapacity() {
        Robot first = new Robot(ROBOT_NAME);
        Robot second = new Robot(ROBOT_NAME);
        Robot third = new Robot(ROBOT_NAME);
        this.service = new Service(SERVICE_NAME, 3);

        this.service.add(first);
        this.service.add(second);
        this.service.add(third);

        Assert.assertEquals(3, this.service.getCount());
    }

    @Test
    public void testRemoveWithExistRobotShouldRemovedSuccessful() {
        Robot robotToRemove = new Robot(ROBOT_NAME);
        Robot first = new Robot("First");
        Robot second = new Robot("Second");
        this.service = new Service(SERVICE_NAME, 3);

        this.service.add(first);
        this.service.add(second);
        this.service.add(robotToRemove);

        this.service.remove(ROBOT_NAME);

        Assert.assertEquals(2, this.service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWithNonExistRobotShouldThrown() {
        Robot first = new Robot("First");
        Robot second = new Robot("Second");
        Robot third = new Robot("Third");
        this.service = new Service(SERVICE_NAME, 3);

        this.service.add(first);
        this.service.add(second);
        this.service.add(third);

        this.service.remove(ROBOT_NAME);
    }

    @Test
    public void testForSaleWithExistRobotShouldSetReadyForSaleFalse() {
        Robot robotForSale = new Robot(ROBOT_NAME);
        Robot first = new Robot("First");
        Robot second = new Robot("Second");
        this.service = new Service(SERVICE_NAME, 3);

        this.service.add(first);
        this.service.add(second);
        this.service.add(robotForSale);

        Assert.assertEquals(robotForSale, this.service.forSale(ROBOT_NAME));
        Assert.assertFalse(robotForSale.isReadyForSale());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleWithNonExistRobotShouldThrown() {
        Robot first = new Robot("First");
        Robot second = new Robot("Second");
        this.service = new Service(SERVICE_NAME, 3);

        this.service.add(first);
        this.service.add(second);

        this.service.forSale(ROBOT_NAME);
    }

    @Test
    public void testReport() {
        Robot first = new Robot("First");
        Robot second = new Robot("Second");
        Robot third = new Robot("Third");
        this.service = new Service(SERVICE_NAME, 3);

        this.service.add(first);
        this.service.add(second);
        this.service.add(third);

        String names = String.join(", ", "First", "Second", "Third");
        String expected = "The robot " + names + " is in the service " + SERVICE_NAME +"!";

        Assert.assertEquals(expected,this.service.report());
    }

    @Test
    public void testGetCount() {
        Robot first = new Robot("First");
        Robot second = new Robot("Second");
        Robot third = new Robot("Third");
        this.service = new Service(SERVICE_NAME, 3);

        this.service.add(first);
        this.service.add(second);
        this.service.add(third);

        Assert.assertEquals(3, this.service.getCount());
    }

}
