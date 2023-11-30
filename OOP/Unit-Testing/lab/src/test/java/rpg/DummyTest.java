package rpg;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 10;
    private static final int DURABILITY_POINTS = 10;

    private Dummy target;
    private Dummy deadTarget;
    private Axe weapon;

    @Before
    public void setUp() {
        // Arrange
        this.target = new Dummy(HEALTH, EXPERIENCE);
        this.deadTarget = new Dummy(0, EXPERIENCE);
        //  this.weapon = new Axe(ATTACK_POINTS,DURABILITY_POINTS);
    }

    @Test
    public void testTakeAttackIfTargetReducesHealth() {
        // Act
        target.takeAttack(ATTACK_POINTS);
        // Assert
        assertEquals(HEALTH - ATTACK_POINTS, this.target.getHealth());
    }

    //Assert
    @Test(expected = IllegalStateException.class)
    public void testTakeAttackIfThrowExWhenTargetIsDead() {
        // Act
        deadTarget.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testGiveExperienceIfDeadTargetCanGiveExperience() {
        // Act
        this.deadTarget.giveExperience();
        //Assert
        assertEquals(EXPERIENCE, this.deadTarget.giveExperience());
    }

    // Assert
    @Test(expected = IllegalStateException.class)
    public void testGiveExperienceIfAliveTargetCanNotGiveExperience() {
        // Act
        this.target.giveExperience();
    }

}
