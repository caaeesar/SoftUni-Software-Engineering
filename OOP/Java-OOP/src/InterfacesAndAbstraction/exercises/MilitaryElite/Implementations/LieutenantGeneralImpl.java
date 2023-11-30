package InterfacesAndAbstraction.exercises.MilitaryElite.Implementations;

import InterfacesAndAbstraction.exercises.MilitaryElite.Interfaces.LieutenantGeneral;
import InterfacesAndAbstraction.exercises.MilitaryElite.Interfaces.Private;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private List<PrivateImpl> privateSoldiers;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privateSoldiers = new ArrayList<>();
    }

    public void addPrivate(Private privateSoldier) {
        this.privateSoldiers.add((PrivateImpl) privateSoldier);
    }

    @Override
    public List<PrivateImpl> getPrivateSoldiers() {
        return Collections.unmodifiableList(this.privateSoldiers);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
     /*   output.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                        super.getFirstName(), super.getLastName(), super.getId(), super.getSalary()))
                .append(System.lineSeparator());*/
        output.append(super.toString());

        output.append("Privates:").append(System.lineSeparator());

        privateSoldiers
                .stream()
                .sorted(Comparator.comparing(PrivateImpl::getId).reversed())
                .forEach(s -> output.append("  ").append(s).append(System.lineSeparator()));

        return output.toString().trim();
    }
}
