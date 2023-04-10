package ReflectionAndAnnotations.exercise.barracksWars;

import ReflectionAndAnnotations.exercise.barracksWars.core.commands.CommandInterpreterImpl;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.CommandInterpreter;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotations.exercise.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotations.exercise.barracksWars.core.Engine;
import ReflectionAndAnnotations.exercise.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotations.exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository,unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
