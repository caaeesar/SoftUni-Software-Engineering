package spaceStation.core;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautsRepo;
    private Repository<Planet> planetsRepo;
    private int exploredPlanetsCount;

    public ControllerImpl(Repository<Astronaut> astronautsRepo, Repository<Planet> planetsRepo) {
        this.astronautsRepo = astronautsRepo;
        this.planetsRepo = planetsRepo;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
        this.astronautsRepo.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(Arrays.asList(items));
        this.planetsRepo.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautsRepo.findByName(astronautName);
        if (astronaut == null) {
            String msg = String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName);
            throw new IllegalArgumentException(msg);
        }
        this.astronautsRepo.remove(astronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Collection<Astronaut> suitableAstronauts = this.astronautsRepo.getModels().stream()
                .filter(a -> a.getOxygen() > 60).collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Planet planet = this.planetsRepo.findByName(planetName);
        Mission mission = new MissionImpl();
        mission.explore(planet, suitableAstronauts);
        this.exploredPlanetsCount++;
        long deadAstronauts = suitableAstronauts.stream().filter(a -> !a.canBreath()).count();

        return String.format(PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append(String.format(REPORT_PLANET_EXPLORED, this.exploredPlanetsCount)).append(System.lineSeparator());
        report.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());

        String itemsOrNone = "";
        for (Astronaut astronaut : this.astronautsRepo.getModels()) {

            report.append(String.format(REPORT_ASTRONAUT_NAME,astronaut.getName())).append(System.lineSeparator());
            report.append(String.format(REPORT_ASTRONAUT_OXYGEN,astronaut.getOxygen())).append(System.lineSeparator());

            if (astronaut.getBag().getItems().isEmpty()) {
                itemsOrNone = "none";
            } else {
                itemsOrNone = String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems());
            }

            report.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, itemsOrNone)).append(System.lineSeparator());
        }

        return report.toString().trim();
    }
}
