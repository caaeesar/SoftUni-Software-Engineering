package magicGame;

import org.junit.Assert;
import org.junit.Test;

public class MagicianTests {

    public static final String DEFAULT_MAGICIAN_USERNAME = "Magician";
    public static final int DEFAULT_MAGICIAN_HEALTH = 0;
    public static final String DEFAULT_MAGIC_NAME = "Magic";
    private Magician defaultMagician;
    private Magic defaultMagic;

    @Test
    public void testConstructorWithValidUsername() {
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, 0);
        Assert.assertEquals(DEFAULT_MAGICIAN_USERNAME, defaultMagician.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullUsernameShouldThrow() {
        defaultMagician = new Magician(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithBlankUsernameShouldThrow() {
        defaultMagician = new Magician("   ", 0);
    }

    @Test
    public void testConstructorWithZeroHealthShouldBeValid() {
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH);
        Assert.assertEquals(DEFAULT_MAGICIAN_HEALTH, defaultMagician.getHealth());
    }

    @Test
    public void testConstructorWithBiggerThanZeroHealthShouldBeValid() {
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH + 100);
        Assert.assertEquals(DEFAULT_MAGICIAN_HEALTH + 100, defaultMagician.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithLowerThanZeroHealth() {
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH - 100);
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicWithNullShouldThrow() {
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH);
        defaultMagician.addMagic(null);
    }

    @Test
    public void testAddMagic() {
        defaultMagic = new Magic(DEFAULT_MAGIC_NAME, 0);
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH);
        defaultMagician.addMagic(defaultMagic);

        Assert.assertEquals(defaultMagic, defaultMagician.getMagics().get(0));
    }

    @Test
    public void testRemoveMagicWithExistMagicShouldReduceSize() {

        Magic magic1 = new Magic("FirstMagic", 0);
        Magic magic2 = new Magic("SecondMagic", 0);
        defaultMagic = new Magic(DEFAULT_MAGIC_NAME, 0);

        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH);
        defaultMagician.addMagic(magic1);
        defaultMagician.addMagic(magic2);
        defaultMagician.addMagic(defaultMagic);

        Assert.assertTrue(defaultMagician.removeMagic(defaultMagic));
        Assert.assertEquals(2, defaultMagician.getMagics().size());
    }

    @Test
    public void testRemoveMagicWithNonExistMagicShouldNotReduceSize() {
        Magic magic1 = new Magic("FirstMagic", 0);
        Magic magic2 = new Magic("SecondMagic", 0);

        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH);
        defaultMagician.addMagic(magic1);
        defaultMagician.addMagic(magic2);

        Assert.assertFalse(defaultMagician.removeMagic(defaultMagic));
        Assert.assertEquals(2, defaultMagician.getMagics().size());
    }

    @Test
    public void testGetMagicWithExistMagic() {
        Magic magic1 = new Magic("FirstMagic", 0);
        Magic magic2 = new Magic("SecondMagic", 0);
        defaultMagic = new Magic(DEFAULT_MAGIC_NAME, 0);

        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH);
        defaultMagician.addMagic(magic1);
        defaultMagician.addMagic(magic2);
        defaultMagician.addMagic(defaultMagic);

        Magic expectedMagic = defaultMagician.getMagic(DEFAULT_MAGIC_NAME);
        Assert.assertEquals(DEFAULT_MAGIC_NAME,expectedMagic.getName());
    }

    @Test
    public void testGetMagicWithNonExistMagicShouldReturnNull() {
        Magic magic1 = new Magic("FirstMagic", 0);
        Magic magic2 = new Magic("SecondMagic", 0);

        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, DEFAULT_MAGICIAN_HEALTH);
        defaultMagician.addMagic(magic1);
        defaultMagician.addMagic(magic2);

        Assert.assertNull(defaultMagician.getMagic(DEFAULT_MAGIC_NAME));
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageWithDeadMagicianShouldThrow() {
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, 0);
        defaultMagician.takeDamage(10);
    }

    @Test
    public void testTakeDamageWithBiggerDamageThanHealthShouldReturnZeroHealth() {
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, 10);
        defaultMagician.takeDamage(20);
        Assert.assertEquals(0,defaultMagician.getHealth());
    }

    @Test
    public void testTakeDamageWithSmallerDamageThanHealthShouldReduceHealth() {
        defaultMagician = new Magician(DEFAULT_MAGICIAN_USERNAME, 10);
        defaultMagician.takeDamage(2);
        Assert.assertEquals(8,defaultMagician.getHealth());
    }
    
}
