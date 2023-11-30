package ReflectionAndAnnotations.exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command{

    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return this.getRepository().getStatistics();
    }
}
