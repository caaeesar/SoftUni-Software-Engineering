package rpg;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AxeTest {

    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 10;
    private static final int DURABILITY_POINTS = 10;

    private Target dummy;
    private Weapon axe;
    private Weapon brokenAxe;

    @Before
    public void setUp() {
        //Arrange
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
        this.axe = new Axe(ATTACK_POINTS, DURABILITY_POINTS);
        this.brokenAxe = new Axe(ATTACK_POINTS, 0);
    }

    @Test
    public void testAttackReducesDurability() {
        //Act
        axe.attack(dummy);
        // Assert
        assertEquals(DURABILITY_POINTS - 1, axe.getDurabilityPoints());
    }

    // Assert
    @Test(expected = IllegalStateException.class)
    public void testAttackThrowExWhenWeaponIsBroken() {
        //Act
        brokenAxe.attack(dummy);
    }

}
