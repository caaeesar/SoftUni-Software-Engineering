package goldDigger.models.spot;

import java.util.*;

import static goldDigger.common.ExceptionMessages.SPOT_NAME_NULL_OR_EMPTY;

public class SpotImpl implements Spot {

    private String name;
    private List<String> exhibits; // todo list ??

    public SpotImpl(String name) {
        this.setName(name);
        this.exhibits = new ArrayList<>(); //todo arrayList ??
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SPOT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    /*public void addExhibits(String...exhibits) {
        List<String> exhibitsList = Arrays.asList(exhibits);
        this.exhibits.addAll(exhibitsList);
    }*/

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
