package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {

    private static final double INITIAL_ENERGY = 60.00;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        if (this.getEnergy() - 7 < 0) {
            this.setEnergy(0);
        } else {
            this.setEnergy(this.getEnergy() - 7);
        }
    }
}
