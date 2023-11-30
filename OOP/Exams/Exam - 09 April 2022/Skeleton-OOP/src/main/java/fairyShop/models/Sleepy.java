package fairyShop.models;

public class Sleepy extends BaseHelper {

    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        int currentEnergy = this.getEnergy() - 15; //todo
        if (currentEnergy < 0){
            currentEnergy = 0;
        }
        this.setEnergy(currentEnergy);
    }
}
