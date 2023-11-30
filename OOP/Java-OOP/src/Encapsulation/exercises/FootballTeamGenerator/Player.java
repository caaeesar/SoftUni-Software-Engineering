package Encapsulation.exercises.FootballTeamGenerator;

public class Player {

    public static final String ENDURANCE = "Endurance";
    public static final String SPRINT = "Sprint";
    public static final String DRIBBLE = "Dribble";
    public static final String PASSING = "Passing";
    public static final String SHOOTING = "Shooting";
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        ValidatorsUtil.validateName(name);
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateStat(ENDURANCE, endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateStat(SPRINT, sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateStat(DRIBBLE, dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateStat(PASSING, passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateStat(SHOOTING, shooting);
        this.shooting = shooting;
    }

    public String getName() {
        return this.name;
    }

    private static void validateStat(String statName, int statValue) {
        if (statValue < 0 || statValue > 100) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", statName));
        }
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.00;
    }

}
