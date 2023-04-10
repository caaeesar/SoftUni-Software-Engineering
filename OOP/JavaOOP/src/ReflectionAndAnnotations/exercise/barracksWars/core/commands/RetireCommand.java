package ReflectionAndAnnotations.exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command {

    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        try {
            getRepository().removeUnit(unitType);
            return String.format("%s retired!",unitType);
        } catch (IllegalStateException e) {
           return e.getMessage();
        }
    }
}
