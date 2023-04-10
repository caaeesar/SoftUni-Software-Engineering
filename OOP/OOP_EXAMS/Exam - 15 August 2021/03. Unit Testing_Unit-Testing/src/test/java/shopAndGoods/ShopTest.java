package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {

    public static final String SHELVES_1 = "Shelves1";
    public static final String SHELVES_2 = "Shelves2";
    public static final String GOODS_CODE = "code";
    private Shop shop;
    private Goods goods;

    @Before
    public void setUp() {
        this.shop = new Shop();
        this.goods = new Goods("Good name", "code");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWithInvalidShelfShouldThrown() throws OperationNotSupportedException {
        Assert.assertEquals("The shelf doesn't exist!", this.shop.addGoods("Invalid Shelf Name", goods));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWithTakenShelfShouldThrown() throws OperationNotSupportedException {
        this.shop.addGoods(SHELVES_1, goods);
        Assert.assertEquals("The shelf is already taken!", this.shop.addGoods(SHELVES_1, new Goods("name", "code")));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsWithExistGoodsShouldThrown() throws OperationNotSupportedException {
        this.shop.addGoods(SHELVES_1, goods);
        Assert.assertEquals("Goods is already in shelf!", this.shop.addGoods(SHELVES_2, goods));
    }

    @Test
    public void testAddGoodsWithValidShelfAndNonExistGoodsShouldAddedSuccessful() throws OperationNotSupportedException {
        Goods first = new Goods("First", GOODS_CODE);
        Goods second = new Goods("Second", GOODS_CODE);

        Assert.assertEquals("Goods: " + GOODS_CODE + " is placed successfully!", this.shop.addGoods(SHELVES_1, first));
        Assert.assertEquals("Goods: " + GOODS_CODE + " is placed successfully!", this.shop.addGoods(SHELVES_2, second));
        Assert.assertEquals(second, shop.getShelves().get(SHELVES_2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWithInvalidShelfShouldThrown() throws OperationNotSupportedException {
        this.shop.addGoods(SHELVES_1, goods);
        Assert.assertEquals("The shelf doesn't exist!", this.shop.removeGoods("Invalid Shelf Name", goods));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWithNonExistGoodsShouldThrown() throws OperationNotSupportedException {
        this.shop.addGoods(SHELVES_1, goods);
        Assert.assertEquals("Goods in that shelf doesn't exists!", this.shop.removeGoods(SHELVES_1, new Goods("invalid", "invalid")));
    }

    @Test
    public void testRemoveGoodsWithValidShelfAndExistGoodsShouldBeRemovedSuccessful() throws OperationNotSupportedException {
        Goods first = new Goods("First", GOODS_CODE);
        Goods second = new Goods("Second", GOODS_CODE);
        this.shop.addGoods(SHELVES_1, first);
        this.shop.addGoods(SHELVES_2, second);
        Assert.assertEquals("Goods: " + GOODS_CODE + " is removed successfully!", this.shop.removeGoods(SHELVES_1, first));
        Assert.assertNull(this.shop.getShelves().get(SHELVES_1));
    }

    @Test
    public void testGetShelves() {
        Map<String, Goods> expected = new LinkedHashMap<>();
        expected.put("Shelves1", null);
        expected.put("Shelves2", null);
        expected.put("Shelves3", null);
        expected.put("Shelves4", null);
        expected.put("Shelves5", null);
        expected.put("Shelves6", null);
        expected.put("Shelves7", null);
        expected.put("Shelves8", null);
        expected.put("Shelves9", null);
        expected.put("Shelves10", null);
        expected.put("Shelves11", null);
        expected.put("Shelves12", null);
        Assert.assertEquals(expected,shop.getShelves());
    }

}