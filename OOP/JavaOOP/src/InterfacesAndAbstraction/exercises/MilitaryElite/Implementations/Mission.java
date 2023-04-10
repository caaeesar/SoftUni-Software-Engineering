package InterfacesAndAbstraction.exercises.MilitaryElite.Implementations;

import InterfacesAndAbstraction.exercises.MilitaryElite.State;

public class Mission {

    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    public void completeMission() {
        this.state = String.valueOf(State.finished);
    }

    public void setState(String state) {
        try {
            if (State.valueOf(state).equals(State.finished) || State.valueOf(state).equals(State.inProgress)) {
                this.state = state;
            }
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid state!");
        }
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
