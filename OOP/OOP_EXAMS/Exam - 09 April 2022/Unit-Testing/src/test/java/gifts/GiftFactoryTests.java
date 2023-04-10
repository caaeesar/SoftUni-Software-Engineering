package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {

    public static final String DEFAULT_GIFT_TYPE = "Some type";
    private Gift gift = new Gift(DEFAULT_GIFT_TYPE, 0);
    private GiftFactory factory;

    @Before
    public void setUp() {
        this.factory = new GiftFactory();
    }

    @Test
    public void testCreateGiftWithNonExistTypeShouldBeAddedSuccessful() {
        factory.createGift(gift);
        Assert.assertEquals(1,factory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftWithExistTypeShouldThrown() {
        factory.createGift(gift);
        Gift sameGift = new Gift(DEFAULT_GIFT_TYPE,0);
        factory.createGift(sameGift);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithNullNameValueShouldThrown() {
        factory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWithBlankNameValueShouldThrown() {
        factory.removeGift("    ");
    }

    @Test
    public void testRemoveGift() {
        factory.createGift(gift);
        Assert.assertTrue(factory.removeGift(DEFAULT_GIFT_TYPE));
    }

    @Test
    public void testGetPresentWithLeastMagicWithExistSuchGift() {
        Gift first = new Gift("First",1);
        Gift second = new Gift("Second",2);
        Gift third = new Gift("Third",3);

        factory.createGift(first);
        factory.createGift(second);
        factory.createGift(third);

        Assert.assertEquals(first,factory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresentWithLeastMagicWithNoSuchGiftShouldReturnNull() {
        Assert.assertNull(factory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresentWithExistGift() {
        Gift first = new Gift("First",1);
        Gift second = new Gift("Second",2);
        Gift third = new Gift("Third",3);

        factory.createGift(first);
        factory.createGift(second);
        factory.createGift(third);
        factory.createGift(gift);

        Assert.assertEquals(gift,factory.getPresent(DEFAULT_GIFT_TYPE));
    }

    @Test
    public void testGetPresentWithExistNonExistGiftShouldReturnNull() {
        Gift first = new Gift("First",1);
        factory.createGift(first);

        Assert.assertNull(factory.getPresent(DEFAULT_GIFT_TYPE));
    }


 /*   @Test
    public void testGetPresents() {
        Gift first = new Gift("First",1);
        Gift second = new Gift("Second",2);
        Gift third = new Gift("Third",3);

        factory.createGift(first);
        factory.createGift(second);
        factory.createGift(third);

        Collection<Gift> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);

        Assert.assertEquals(Collections.unmodifiableCollection(expected),factory.getPresents());
    }*/

}
