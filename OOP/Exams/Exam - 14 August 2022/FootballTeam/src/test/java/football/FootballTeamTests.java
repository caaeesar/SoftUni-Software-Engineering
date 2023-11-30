package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {

    public static final String DEFAULT_NAME = "Some name";
    public static final int DEFAULT_ZERO_VACANT_POSITIONS = 0;
    public static final String DEFAULT_FOOTBALLER_NAME = "FootballerName";
    public static final String INVALID_NAME = "invalidName";
    private FootballTeam team;
    private Footballer footballer;

    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullNameShouldThrown() {
        this.team = new FootballTeam(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithBlankNameShouldThrown() {
        this.team = new FootballTeam("    ", 0);
    }

    @Test
    public void testConstructorWithValidName() {
        this.team = new FootballTeam(DEFAULT_NAME, 0);
        Assert.assertEquals(DEFAULT_NAME, team.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithSmallerThanZeroVacantPositionsShouldThrown() {
        team = new FootballTeam(DEFAULT_NAME, DEFAULT_ZERO_VACANT_POSITIONS - 1);
    }

    @Test
    public void testConstructorWithZeroVacantPositionsShouldBeValid() {
        team = new FootballTeam(DEFAULT_NAME,DEFAULT_ZERO_VACANT_POSITIONS);
        Assert.assertEquals(DEFAULT_ZERO_VACANT_POSITIONS,team.getVacantPositions());
    }

    @Test
    public void testConstructorWithBiggerThanZeroVacantPositionsShouldBeValid() {
        team = new FootballTeam(DEFAULT_NAME,DEFAULT_ZERO_VACANT_POSITIONS + 10);
        Assert.assertEquals(10,team.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerWithoutMoreVacantPositionsShouldThrown() {
        team = new FootballTeam(DEFAULT_NAME,1);
        footballer = new Footballer("FootballerName");
        Footballer first = new Footballer("First");

        team.addFootballer(footballer);
        team.addFootballer(first);
    }

    @Test
    public void testAddFootballerWithVacantPositionsShouldBeSuccessfulAdded() {
        team = new FootballTeam(DEFAULT_NAME,2);
        footballer = new Footballer("FootballerName");
        team.addFootballer(footballer);

        Assert.assertEquals(1,team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerWithNonExistFootballerShouldThrown() {
        team = new FootballTeam(DEFAULT_NAME,2);
        footballer = new Footballer("FootballerName");
        team.addFootballer(footballer);
        team.removeFootballer(INVALID_NAME);
    }

    @Test
    public void testRemoveFootballerWithExistFootballerShouldSuccessfulRemoved() {
        team = new FootballTeam(DEFAULT_NAME,2);
        footballer = new Footballer(DEFAULT_FOOTBALLER_NAME);
        team.addFootballer(footballer);
        team.removeFootballer(DEFAULT_FOOTBALLER_NAME);
        Assert.assertEquals(0,team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleWithNonExistFootballerShouldThrow() {
        team = new FootballTeam(DEFAULT_NAME,2);
        footballer = new Footballer(DEFAULT_FOOTBALLER_NAME);
        team.addFootballer(footballer);

       team.footballerForSale(INVALID_NAME);
    }

    @Test
    public void testFootballerForSaleWithExistFootballerShouldBeInActive() {
        team = new FootballTeam(DEFAULT_NAME,2);
        footballer = new Footballer(DEFAULT_FOOTBALLER_NAME);
        team.addFootballer(footballer);
        team.footballerForSale(DEFAULT_FOOTBALLER_NAME);

        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void testFootballerForSaleWithExistFootballerShouldReturnCorrectFootballer() {
        team = new FootballTeam(DEFAULT_NAME,2);
        footballer = new Footballer(DEFAULT_FOOTBALLER_NAME);
        team.addFootballer(footballer);
        Assert.assertEquals(footballer,team.footballerForSale(DEFAULT_FOOTBALLER_NAME));
    }

}
