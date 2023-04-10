package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToyStoryTest {

    public static final String INVALID_SHELF = "Shelf";
    private Toy defaultToy;
    private Toy secondToy;
    private ToyStore defaultStore;

    @Before
    public void setUp() {
        defaultToy = new Toy("defaultManufacturer", "defaultToyId");
        secondToy = new Toy("SomeManufacturer", "someToyId");
        defaultStore = new ToyStore();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyWithNonExistShelfShouldThrow() throws OperationNotSupportedException {
        defaultStore.addToy(INVALID_SHELF, defaultToy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyWithTakenShelfShouldThrow() throws OperationNotSupportedException {
        defaultStore.addToy("A", defaultToy);
        defaultStore.addToy("A", secondToy);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyWithExistToyShouldThrow() throws OperationNotSupportedException {
        defaultStore.addToy("A", defaultToy);
        defaultStore.addToy("B", defaultToy);
    }

    @Test
    public void testAddToyWithNonExistToyAndNotTakenShelfShouldAddValid() throws OperationNotSupportedException {
        Toy thirdToy = new Toy("Third","3");
        defaultStore.addToy("A", defaultToy);
        defaultStore.addToy("B", secondToy);
        Assert.assertEquals(defaultToy, defaultStore.getToyShelf().get("A"));
        String msg = String.format("Toy:%s placed successfully!", thirdToy.getToyId());
        Assert.assertEquals(msg,defaultStore.addToy("C", thirdToy));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWithNonExistToyShouldThrow() throws OperationNotSupportedException {
        defaultStore.addToy("A", defaultToy);
        defaultStore.removeToy("A", secondToy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWithNonExistShelfShouldThrow() throws OperationNotSupportedException {
        defaultStore.addToy("A", defaultToy);
        defaultStore.removeToy(INVALID_SHELF, defaultToy);
    }

    @Test
    public void testRemoveToyWithExistShelfAndExistToy() throws OperationNotSupportedException {
        defaultStore.addToy("A", defaultToy);
        defaultStore.addToy("B",secondToy);
        defaultStore.removeToy("A", defaultToy);

        String msg = String.format("Remove toy:%s successfully!", secondToy.getToyId());
        Assert.assertEquals(msg,defaultStore.removeToy("B",secondToy));
        Assert.assertNull(defaultStore.getToyShelf().get("A"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetToyShelfIfReturnUnmodifiableMap() {
        defaultStore.getToyShelf().put("A", defaultToy);
    }

    @Test
    public void testGetToyIfReturnValid() throws OperationNotSupportedException {
        Map<String, Toy> expected = new LinkedHashMap<>();
        expected.put("A", defaultToy);
        expected.put("B", secondToy);
        expected.put("C", null);
        expected.put("D", null);
        expected.put("E", null);
        expected.put("F", null);
        expected.put("G", null);

        defaultStore.addToy("A", defaultToy);
        defaultStore.addToy("B", secondToy);

        Assert.assertEquals(expected,defaultStore.getToyShelf());
    }



}