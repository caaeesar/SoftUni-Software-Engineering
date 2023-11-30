package spaceStation;

import spaceStation.core.Controller;
import spaceStation.core.ControllerImpl;
import spaceStation.core.Engine;
import spaceStation.core.EngineImpl;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

public class Main {
    public static void main(String[] args) {

        Repository<Astronaut> astronautRepository = new AstronautRepository();
        Repository<Planet> planetRepository = new PlanetRepository();

        Controller controller = new ControllerImpl(astronautRepository, planetRepository);
        Engine engine = new EngineImpl(controller);
        engine.run();

    }
}
