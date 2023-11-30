package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Explorer> explorersRepo;
    private Repository<State> statesRepo;
    private int exploredStatesCount = 0;
    private int retiredCount = 0;

    public ControllerImpl() {
        this.explorersRepo = new ExplorerRepository();
        this.statesRepo = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }
        this.explorersRepo.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        state.getExhibits().addAll(Arrays.asList(exhibits));
        this.statesRepo.add(state);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorersRepo.byName(explorerName);
        if (explorer == null) {
            String msg = String.format(EXPLORER_DOES_NOT_EXIST, explorerName);
            throw new IllegalArgumentException(msg);
        }
        this.explorersRepo.remove(explorer);
        this.retiredCount++;
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        Collection<Explorer> suitableExplorers = this.explorersRepo.getCollection().stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        if (suitableExplorers.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State state = this.statesRepo.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(state, suitableExplorers);
        this.exploredStatesCount++;

       // int retiredCount = this.explorersRepo.getCollection().size() - suitableExplorers.size(); //todo
        return String.format(STATE_EXPLORER, stateName, retiredCount);
    }

    @Override
    public String finalResult() {
        StringBuilder out = new StringBuilder();
        out.append(String.format(FINAL_STATE_EXPLORED, exploredStatesCount)).append(System.lineSeparator());
        out.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());

        String exhibitsOrNone = "";
        for (Explorer explorer : this.explorersRepo.getCollection()) {

            out.append(String.format(FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            out.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());

            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                exhibitsOrNone = "None";
            } else {
                exhibitsOrNone = String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits());
            }
            out.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, exhibitsOrNone)).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
