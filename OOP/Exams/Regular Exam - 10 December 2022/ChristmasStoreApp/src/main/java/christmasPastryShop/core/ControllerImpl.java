package christmasPastryShop.core;

import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0.00;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);
        if (delicacy == null) {
            switch (type) {
                case "Gingerbread":
                    delicacy = new Gingerbread(name, price);
                    break;
                case "Stolen":
                    delicacy = new Stolen(name, price);
                    break;
            }
            this.delicacyRepository.add(delicacy);
            return String.format(DELICACY_ADDED, name, type);
        } else {
            String msg = String.format(FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);
        if (cocktail == null) {
            switch (type) {
                case "MulledWine":
                    cocktail = new MulledWine(name, size, brand);
                    break;
                case "Hibernation":
                    cocktail = new Hibernation(name, size, brand);
                    break;
            }
            this.cocktailRepository.add(cocktail);
            return String.format(COCKTAIL_ADDED, name, brand);
        } else {
            String msg = String.format(FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        if (booth == null) {
            switch (type) {
                case "OpenBooth":
                    booth = new OpenBooth(boothNumber, capacity);
                    break;
                case "PrivateBooth":
                    booth = new PrivateBooth(boothNumber, capacity);
                    break;
            }
            this.boothRepository.add(booth);
            return String.format(BOOTH_ADDED, boothNumber);
        } else {
            String msg = String.format(BOOTH_EXIST, boothNumber);
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth booth = this.boothRepository
                .getAll()
                .stream()
                .filter(b -> !b.isReserved() && b.getCapacity() >= numberOfPeople).findFirst().orElse(null);
        if (booth == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        booth.reserve(numberOfPeople);
        return String.format(BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        this.totalIncome += bill;
        booth.clear();
        return String.format("Booth: %d\nBill: %.2f", boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format("Income: %.2flv", this.totalIncome);
    }
}
