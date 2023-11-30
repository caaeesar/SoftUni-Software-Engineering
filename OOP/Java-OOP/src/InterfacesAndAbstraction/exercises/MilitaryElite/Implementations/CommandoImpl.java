package InterfacesAndAbstraction.exercises.MilitaryElite.Implementations;

import InterfacesAndAbstraction.exercises.MilitaryElite.Interfaces.Commando;
import InterfacesAndAbstraction.exercises.MilitaryElite.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missions = new ArrayList<>();
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("%s",
                        super.toString()))
                .append(System.lineSeparator());

        output.append(String.format("Corps: %s", super.getCorp())).append(System.lineSeparator());

        output.append("Missions:").append(System.lineSeparator());

        for (Mission mission : this.missions) {
            output.append("  ").append(mission).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
