package rpg;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;

    @Test
    public void testAttackIfHeroGainsExperienceWhenTargetDies() {

        //Arrange
        Target mockedTarget = mock(Target.class);
        when(mockedTarget.isDead()).thenReturn(true);
        int targetExperience = 10;
        when(mockedTarget.giveExperience()).thenReturn(targetExperience);

        Weapon mockedWeapon = mock(Weapon.class);
        this.hero = new Hero("Melisa", mockedWeapon);

        // Act
        hero.attack(mockedTarget);

        //Assert
        assertEquals(targetExperience, hero.getExperience());
    }

}
