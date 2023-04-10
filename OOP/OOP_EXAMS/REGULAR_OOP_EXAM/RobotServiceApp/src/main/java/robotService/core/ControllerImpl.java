package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.Repository;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        switch (type) {
            case "MainService":
                service = new MainService(name);
                break;
            case "SecondaryService":
                service = new SecondaryService(name);
                break;
            default:
                throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        this.services.add(service);
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "PlasticArmor":
                supplement = new PlasticArmor();
                break;
            case "MetalArmor":
                supplement = new MetalArmor();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        this.supplements.addSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);
        if (supplement == null) {
            String msg = String.format(NO_SUPPLEMENT_FOUND, supplementType);
            throw new IllegalArgumentException(msg);
        }
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().get();
        service.addSupplement(supplement);
        this.supplements.removeSupplement(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;
        switch (robotType) {
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;
            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().get();

        boolean canLive = (robotType.equals("MaleRobot") && service.getClass().getSimpleName().equals("MainService")) ||
                (robotType.equals("FemaleRobot") && service.getClass().getSimpleName().equals("SecondaryService"));

        if (canLive) {
            service.addRobot(robot);
            return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
        }

        return UNSUITABLE_SERVICE;
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().get();
        service.feeding();
        return String.format(FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        double totalPrice = 0.00;
        Service service = this.services.stream().filter(s -> s.getName().equals(serviceName)).findFirst().get();
        totalPrice += service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        totalPrice += service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();

        return String.format(VALUE_SERVICE, serviceName,totalPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        for (Service service : this.services) {
            out.append(service.getStatistics()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
