package _01_;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private static final int CAPACITY = 16;

    @Test
    public void testDatabaseConstructor() throws OperationNotSupportedException {
        Integer[] elements = {1, 2, 3, 4, 5, 6};
        Database database = new Database(elements);
        Integer[] dbElements = database.getElements();
        assertArrayEquals(elements, dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorMoreThan16ElementsThrows() throws OperationNotSupportedException {
        Integer[] elements = new Integer[CAPACITY + 1];
        Database database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorLessThan16ElementsThrows() throws OperationNotSupportedException {
        Integer[] elements = new Integer[0];
        Database database = new Database(elements);
    }

    @Test
    public void testAdd() throws OperationNotSupportedException {
        Integer[] elements = {0, 10, 20, 30, 40, 50};
        int initSize = elements.length;
        Database database = new Database(elements);
        int addedValue = 60;
        database.add(addedValue);
        int dbLastValue = database.getElements()[database.getElements().length - 1];

        assertEquals(initSize + 1, database.getElements().length);
        assertEquals(addedValue, dbLastValue);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullShouldThrow() throws OperationNotSupportedException {
        Integer[] elements = {1, 2, 3, 4, 5, 6};
        Database database = new Database(elements);
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveEmptyDatabaseThrow() throws OperationNotSupportedException {
        Integer[] elements = {1, 2, 3, 4, 5, 6};
        Database database = new Database(elements);
        for (int i = 0; i < elements.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        Integer[] elements = {1, 2, 3, 4, 5, 6};
        int initSize = elements.length;
        int previousElement = elements[elements.length - 2];

        Database database = new Database(elements);
        database.remove();
        int previousDBLastElement = database.getElements()[database.getElements().length - 1];

        assertEquals(initSize - 1,database.getElements().length);
        assertEquals(previousElement,previousDBLastElement);
    }
}
