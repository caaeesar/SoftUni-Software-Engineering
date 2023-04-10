package fairyShop.core;

import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;
import fairyShop.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static fairyShop.common.ConstantMessages.*;
import static fairyShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Helper> helperRepo;
    private Repository<Present> presentRepo;
    private Collection<Helper> workedHelpers;

    public ControllerImpl() {
        this.helperRepo = new HelperRepository();
        this.presentRepo = new PresentRepository();
        this.workedHelpers = new ArrayList<>();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(HELPER_TYPE_DOESNT_EXIST);
        }
        this.helperRepo.add(helper);
        return String.format(ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = this.helperRepo.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        Instrument instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);
        return String.format(SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        this.presentRepo.add(new PresentImpl(presentName, energyRequired));
        return String.format(SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Collection<Helper> readyHelpers = this.helperRepo
                .getModels()
                .stream()
                .filter(h -> h.getEnergy() > 50)
                .collect(Collectors.toList());

        if (readyHelpers.isEmpty()) {
            throw new IllegalArgumentException(NO_HELPER_READY);
        }

        String doneOrNotDone = "";
        int brokenInstrumentsCount = 0;

        Shop shop = new ShopImpl();
        Present present = this.presentRepo.findByName(presentName);
        for (Helper helper : readyHelpers) {
            shop.craft(present, helper);
            this.workedHelpers.add(helper);
            long count = helper.getInstruments().stream().filter(Instrument::isBroken).count();
            brokenInstrumentsCount += count;
        }
        if (present.isDone()) {
            doneOrNotDone = "done";
        } else {
            doneOrNotDone = "not done";
        }

        StringBuilder msg = new StringBuilder();
        msg.append(String.format(PRESENT_DONE, presentName, doneOrNotDone))
                .append(String.format(COUNT_BROKEN_INSTRUMENTS, brokenInstrumentsCount))
                .append(System.lineSeparator());
        return msg.toString().trim();
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        long countCraftPresent = this.presentRepo.getModels().stream().filter(Present::isDone).count();

        report.append(String.format("%d presents are done!", countCraftPresent));
        report.append(System.lineSeparator());
        report.append("Helpers info:").append(System.lineSeparator());
        for (Helper helper : this.helperRepo.getModels()) {
            report.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator());
            report.append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator());
            long count = helper.getInstruments().stream().filter(i -> !i.isBroken()).count();
            report.append(String.format("Instruments: %d not broken left", count)).append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
