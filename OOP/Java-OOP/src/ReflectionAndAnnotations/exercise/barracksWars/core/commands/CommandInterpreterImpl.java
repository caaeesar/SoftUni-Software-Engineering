package ReflectionAndAnnotations.exercise.barracksWars.core.commands;

import ReflectionAndAnnotations.exercise.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Executable;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.UnitFactory;

public class CommandInterpreterImpl implements CommandInterpreter {

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        switch (commandName) {
            case "add":
                return new AddUnitCommand(data, repository, unitFactory);
            case "report":
                return new ReportCommand(data, repository, unitFactory);
            case "fight":
                return new FightCommand(data, repository, unitFactory);
            case "retire":
                return new RetireCommand(data, repository, unitFactory);
            default:
                throw new RuntimeException("Invalid command!");
        }
    }
}
