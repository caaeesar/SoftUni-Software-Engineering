package ReflectionAndAnnotations.exercise.barracksWars.models.units;

public class Gunner extends AbstractUnit{

    private static final int SWORDSMAN_HEALTH = 40;
    private static final int SWORDSMAN_DAMAGE = 13;

    public Gunner() {
        super(SWORDSMAN_HEALTH, SWORDSMAN_DAMAGE);
    }
}
