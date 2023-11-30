package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.decorations.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null) {
            String msg = String.format(NO_DECORATION_FOUND, decorationType);
            throw new IllegalArgumentException(msg);
        }

        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName))
                .findFirst().get();

        aquarium.addDecoration(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().get();

        boolean canFreshFishLive = false;
        boolean canSaltwaterFishLive = false;
        int capacity = 0;
        if (aquarium.getClass().getSimpleName().equals("FreshwaterAquarium") &&
                fishType.equals("FreshwaterFish")) {
            capacity = 50;
            canFreshFishLive = true;
        } else if (aquarium.getClass().getSimpleName().equals("SaltwaterAquarium") &&
                fishType.equals("SaltwaterFish")) {
            capacity = 25;
            canSaltwaterFishLive = true;
        }

        if (!canFreshFishLive && !canSaltwaterFishLive) {
            return WATER_NOT_SUITABLE;
        } else if (canFreshFishLive || canSaltwaterFishLive) {

            if (aquarium.getFish().size() >= capacity) {
                return NOT_ENOUGH_CAPACITY;
            } else {
                aquarium.addFish(fish);
                return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
            }
        }
        return null; //todo
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().get();
        aquarium.getFish().forEach(Fish::eat);
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().get();
        double totalFishPrice = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double totalDecorationsPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        return String.format(VALUE_AQUARIUM, aquariumName, totalFishPrice + totalDecorationsPrice);
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        for (Aquarium aquarium : this.aquariums) {
            report.append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
