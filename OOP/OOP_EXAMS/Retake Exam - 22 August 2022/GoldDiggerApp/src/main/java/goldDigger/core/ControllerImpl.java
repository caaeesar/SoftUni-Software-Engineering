package goldDigger.core;

import goldDigger.models.discoverer.*;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.Repository;
import goldDigger.repositories.SpotRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Discoverer> discoverersRepo;
    private Repository<Spot> spotsRepo;
    private int spotCount;

    public ControllerImpl() {
        this.discoverersRepo = new DiscovererRepository();
        this.spotsRepo = new SpotRepository();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        BaseDiscoverer discoverer;
        switch (kind) {
            case "Archaeologist":
                discoverer = new Archaeologist(discovererName);
                break;
            case "Anthropologist":
                discoverer = new Anthropologist(discovererName);
                break;
            case "Geologist":
                discoverer = new Geologist(discovererName);
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        this.discoverersRepo.add(discoverer);
        return String.format(DISCOVERER_ADDED,kind,discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        spot.getExhibits().addAll(Arrays.asList(exhibits)); // todo
        this.spotsRepo.add(spot);
        return String.format(SPOT_ADDED,spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = this.discoverersRepo.byName(discovererName);
        if (discoverer == null) {
            String msg = String.format(DISCOVERER_DOES_NOT_EXIST,discovererName);
            throw new IllegalArgumentException(msg);
        }
        this.discoverersRepo.remove(discoverer);
        return String.format(DISCOVERER_EXCLUDE,discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> suitableDiscoverer = new ArrayList<>();

        for (Discoverer discoverer : this.discoverersRepo.getCollection()) {
            if (discoverer.getEnergy() > 45) {
                suitableDiscoverer.add(discoverer);
            }
        }

        if (suitableDiscoverer.isEmpty()) {
            return SPOT_DISCOVERERS_DOES_NOT_EXISTS;
        }

        Spot spot = this.spotsRepo.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot, suitableDiscoverer);
        this.spotCount++;

        long excludedCount = suitableDiscoverer.stream().filter(d -> d.getEnergy() <= 0).count();
        return String.format(INSPECT_SPOT,spotName,excludedCount);
    }

    @Override
    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format(FINAL_SPOT_INSPECT,this.spotCount)).append(System.lineSeparator());
        statistics.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());

        for (Discoverer discoverer : this.discoverersRepo.getCollection()) {

            statistics.append(String.format(FINAL_DISCOVERER_NAME,discoverer.getName())).append(System.lineSeparator());
            statistics.append(String.format(FINAL_DISCOVERER_ENERGY,discoverer.getEnergy())).append(System.lineSeparator());

            if (discoverer.getMuseum().getExhibits().isEmpty()) {
                statistics.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,"None"));
            } else {
            String exhibits = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits());
            statistics.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,exhibits));
            }
        }
        return statistics.toString().trim();
    }
}
