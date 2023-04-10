package InterfacesAndAbstraction.exercises.MilitaryElite.Implementations;

import InterfacesAndAbstraction.exercises.MilitaryElite.Interfaces.Spy;
import InterfacesAndAbstraction.exercises.MilitaryElite.SoldierImpl;

public class SpyImpl extends SoldierImpl implements Spy {

    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d\nCode Number: %s",
                super.getFirstName(), super.getLastName(), super.getId(), this.codeNumber);
    }
}
