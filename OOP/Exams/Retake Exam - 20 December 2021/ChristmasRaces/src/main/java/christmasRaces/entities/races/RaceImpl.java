package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static christmasRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.drivers = new ArrayList<>(); // todo
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5) {
            String msg = String.format(INVALID_NAME, name, 5);
            throw new IllegalArgumentException(msg);
        }
        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < 1) {
            String msg = String.format(INVALID_NUMBER_OF_LAPS, 1);
            throw new IllegalArgumentException(msg);
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return Collections.unmodifiableCollection(this.drivers);
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }

        if (!driver.getCanParticipate()) {
            String msg = String.format(DRIVER_NOT_PARTICIPATE,driver.getName());
            throw new IllegalArgumentException(msg);
        }

        Driver searchDriver = this.drivers
                .stream()
                .filter(d -> d.equals(driver))
                .findFirst()
                .orElse(null);
        if (searchDriver != null) {
            String msg = String.format(DRIVER_ALREADY_ADDED,searchDriver.getName(),this.name);
            throw new IllegalArgumentException(msg);
        }

        this.drivers.add(driver);
    }
}
