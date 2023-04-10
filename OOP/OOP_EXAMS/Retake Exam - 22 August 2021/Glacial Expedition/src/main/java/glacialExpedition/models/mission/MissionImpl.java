package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.Iterator;

public class MissionImpl implements Mission {
    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        Iterator<String> exhibits = state.getExhibits().iterator();
        boolean isHaveMoreExhibitsToSearch = true;

        for (Explorer explorer : explorers) {

            while (explorer.canSearch()) {

                if (exhibits.hasNext()) {

                    explorer.search();                           //todo
                    String currentExhibit = exhibits.next();
                    exhibits.remove();
                    explorer.getSuitcase().getExhibits().add(currentExhibit);
                    if (!exhibits.hasNext()) {
                        isHaveMoreExhibitsToSearch = false;
                        break;
                    }
                }
            }
            if (!isHaveMoreExhibitsToSearch){
                break;
            }
        }
    }
}
