package ReflectionAndAnnotations.exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.UnitFactory;

public class AddUnitCommand extends Command{

    public AddUnitCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
