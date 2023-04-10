package InterfacesAndAbstraction.exercises.MilitaryElite.Implementations;

import InterfacesAndAbstraction.exercises.MilitaryElite.Interfaces.Engineer;
import InterfacesAndAbstraction.exercises.MilitaryElite.Interfaces.Repair;
import InterfacesAndAbstraction.exercises.MilitaryElite.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(RepairImpl repairImpl) {
        this.repairs.add(repairImpl);
    }

    @Override
    public Collection<Repair> getRepair() {
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s\nCorps: %s", super.toString(),super.getCorp()))
                .append(System.lineSeparator());

        output.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : this.repairs) {
            output.append(" ").append(repair).append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
