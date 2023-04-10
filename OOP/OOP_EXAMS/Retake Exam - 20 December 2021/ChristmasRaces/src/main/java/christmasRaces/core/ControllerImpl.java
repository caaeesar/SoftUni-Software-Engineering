package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver searchDriver = this.driverRepository.getAll().stream()
                .filter(d -> d.getName().equals(driver))
                .findFirst().orElse(null);

        if (searchDriver != null) {
            String msg = String.format(DRIVER_EXISTS, driver);
            throw new IllegalArgumentException(msg);
        }

        this.driverRepository.add(new DriverImpl(driver));
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = this.carRepository.getByName(model);
        if (car == null) {
            switch (type) {
                case "Muscle":
                    car = new MuscleCar(model, horsePower);
                    break;
                case "Sports":
                    car = new SportsCar(model, horsePower);
                    break;
            }
        } else {
            String msg = String.format(CAR_EXISTS, model);
            throw new IllegalArgumentException(msg);
        }

        this.carRepository.add(car);
        return String.format(CAR_CREATED, car.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            String msg = String.format(DRIVER_NOT_FOUND, driverName);
            throw new IllegalArgumentException(msg);
        }

        Car car = this.carRepository.getByName(carModel);
        if (car == null) {
            String msg = String.format(CAR_NOT_FOUND, carModel);
            throw new IllegalArgumentException(msg);
        }

        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            String msg = String.format(RACE_NOT_FOUND, raceName);
            throw new IllegalArgumentException(msg);
        }

        Driver driver = this.driverRepository.getByName(driverName);
        if (driver == null) {
            String msg = String.format(DRIVER_NOT_FOUND, driverName);
            throw new IllegalArgumentException(msg);
        }

        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);

        if (race == null) {
            String msg = String.format(RACE_NOT_FOUND, raceName);
            throw new IllegalArgumentException(msg);
        }

        if (race.getDrivers().size() < 3) {
            String msg = String.format(RACE_INVALID, raceName, 3);
            throw new IllegalArgumentException(msg);
        }

        Collection<Driver> drivers = race.getDrivers();
        Map<Driver, Double> driversPoints = new HashMap<>();
        for (Driver driver : drivers) {
            Car car = driver.getCar();
            int laps = race.getLaps();
            driversPoints.putIfAbsent(driver, car.calculateRacePoints(laps));
        }

        Collection<Map.Entry<Driver, Double>> sorted = driversPoints.entrySet().stream()
                .sorted((d1, d2) -> d2.getValue().compareTo(d1.getValue()))
                .limit(3)
                .collect(Collectors.toList());

        StringBuilder out = new StringBuilder();
        int position = 0;
        for (Map.Entry<Driver, Double> entry : sorted) { // todo refactor
            position++;
            Driver driver = entry.getKey();
            if (position == 1) {
                out.append(String.format(DRIVER_FIRST_POSITION, driver.getName(), raceName)).append(System.lineSeparator());
            } else if (position == 2) {
                out.append(String.format(DRIVER_SECOND_POSITION, driver.getName(), raceName)).append(System.lineSeparator());
            } else if (position == 3) {
                out.append(String.format(DRIVER_THIRD_POSITION, driver.getName(), raceName));
            }
        }

        this.raceRepository.remove(race);
        return out.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = this.raceRepository.getByName(name);
        if (race != null) {
            String msg = String.format(RACE_EXISTS, name);
            throw new IllegalArgumentException(msg);
        }

        race = new RaceImpl(name, laps);
        this.raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
