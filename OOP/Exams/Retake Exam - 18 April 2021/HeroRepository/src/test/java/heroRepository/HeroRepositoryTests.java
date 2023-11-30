package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {

    public static final String HERO_NAME = "Hero name";
    public static final int LEVEL = 0;
    private HeroRepository repo;

    @Before
    public void setUp() {
        this.repo = new HeroRepository();
    }

    @Test(expected = NullPointerException.class)
    public void testCreateWithNullShouldThrown() {
        Assert.assertEquals("Hero is null", this.repo.create(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroWithSameNameShouldThrown() {
        Hero first = new Hero(HERO_NAME, 0);
        this.repo.create(first);
        Hero second = new Hero(HERO_NAME, 0);
        Assert.assertEquals("Hero with name %s already exists", this.repo.create(second));
    }

    @Test
    public void testCreateWithDifferentNameShouldBeCreatedSuccessful() {
        Hero first = new Hero("First", 0);
        this.repo.create(first);
        Hero second = new Hero(HERO_NAME, LEVEL);

        Assert.assertEquals("Successfully added hero " + HERO_NAME + " with level " + LEVEL, this.repo.create(second));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithNullShouldThrown() {
        this.repo.create(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithBlankShouldThrown() {
        this.repo.remove("    ");
    }

    @Test
    public void testRemoveWithExistHero() {
        Hero first = new Hero("First", 0);
        Hero second = new Hero("Second", 0);

        this.repo.create(first);
        this.repo.create(second);

        Assert.assertTrue(this.repo.remove(first.getName()));
    }

    @Test
    public void testRemoveWithNonExistHero() {
        Hero first = new Hero("First", 0);
        Hero second = new Hero("Second", 0);

        this.repo.create(first);
        this.repo.create(second);

        Assert.assertFalse(this.repo.remove("invalid name"));
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        Hero first = new Hero("First", 1);
        Hero second = new Hero("Second", 2);
        Hero third = new Hero("Third", 3);
        Hero four = new Hero("Four", 4);
        Hero five = new Hero("Five", 5);

        this.repo.create(first);
        this.repo.create(second);
        this.repo.create(third);
        this.repo.create(four);
        this.repo.create(five);

        Assert.assertEquals(five,this.repo.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelWithoutHeroesShouldReturnNull() {
        Assert.assertNull(this.repo.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelWithSameHeroesLevelShouldReturnFirst() {
        Hero first = new Hero("First", 1);
        Hero second = new Hero("Second", 1);
        this.repo.create(first);
        this.repo.create(second);
        Assert.assertEquals(first,this.repo.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithExistHero() {
        Hero hero = new Hero(HERO_NAME, 1);
        this.repo.create(hero);
        Assert.assertEquals(hero,this.repo.getHero(HERO_NAME));
    }

    @Test
    public void testGetHeroWithNoneExistHeroShouldReturnNull() {
        Hero hero = new Hero(HERO_NAME, 1);
        this.repo.create(hero);
        Assert.assertNull(this.repo.getHero("some name"));
    }
}
