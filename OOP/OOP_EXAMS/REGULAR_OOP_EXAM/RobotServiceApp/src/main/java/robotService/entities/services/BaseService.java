package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT;
import static robotService.common.ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseService implements Service {

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    protected BaseService(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return Collections.unmodifiableCollection(this.robots);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(this.supplements);
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.capacity <= this.robots.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        this.robots.forEach(Robot::eating);
    }

    @Override
    public int sumHardness() {
        return this.supplements.stream().mapToInt(Supplement::getHardness).sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        statistics.append(String.format("%s %s:", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());

        String robotsOrNone = "";
        if (this.robots.isEmpty()) {
            robotsOrNone = "none";
        } else {
            Collection<String> robotsNames = this.robots.stream().map(Robot::getName).collect(Collectors.toList());
            robotsOrNone = String.join(" ", robotsNames);
        }

        statistics.append(String.format("Robots: %s",robotsOrNone)).append(System.lineSeparator());
        statistics.append(String.format("Supplements: %d Hardness: %d",this.supplements.size(),this.sumHardness()));

        return statistics.toString().trim();
    }
}
