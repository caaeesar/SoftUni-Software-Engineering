package _03_;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator iterator;
    private static final String[] ELEMENTS = {"0", "1", "2"};
    private static final String[] EMPTY_ARRAY = {};

    @Before
    public void setUp() throws OperationNotSupportedException {
        iterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorIfThrowWithNull() throws OperationNotSupportedException {
        iterator = new ListIterator(null);
    }

    @Test
    public void testMove() {
        assertTrue(iterator.move());
        assertTrue(iterator.move());
        assertFalse(iterator.move());
    }

    @Test
    public void testPrint() {
        String firstElement = ELEMENTS[0];
        String firstPrint = iterator.print();
        assertEquals(firstElement, firstPrint);
        iterator.move();
        String secondElement = ELEMENTS[1];
        String secondPrint = iterator.print();
        assertEquals(secondElement, secondPrint);
        iterator.move();
        String thirdElement = ELEMENTS[2];
        String thirdPrint = iterator.print();
        assertEquals(thirdElement, thirdPrint);
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWithoutElements() throws OperationNotSupportedException {
        iterator = new ListIterator(EMPTY_ARRAY);
        iterator.print();
    }
}
