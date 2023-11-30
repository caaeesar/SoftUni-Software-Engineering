package InterfacesAndAbstraction.exercises.MilitaryElite;

import InterfacesAndAbstraction.exercises.MilitaryElite.Implementations.PrivateImpl;
import InterfacesAndAbstraction.exercises.MilitaryElite.Interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private String corp;

    protected SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.setCorp(corp);
    }

    @Override
    public String getCorp() {
        return this.corp;
    }

    public void setCorp(String corp) {
        try {
        if (Corp.valueOf(corp).equals(Corp.Airforces) ||
                Corp.valueOf(corp).equals(Corp.Marines)) {
            this.corp = corp;
        }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Corp!");
        }
    }
}
