package _04_;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void testSort() {
        int[] numbers = {3, 60, 35, -2, 45, 320, 5};
        int[] sortedArray = {-2, 3, 5, 35, 45, 60, 320};
        Bubble.sort(numbers);
        Assert.assertArrayEquals(sortedArray,numbers);
    }
}
