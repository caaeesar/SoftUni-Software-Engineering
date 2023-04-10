package ReflectionAndAnnotations.exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.UnitFactory;

public class FightCommand extends Command{
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
