package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Iterator;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        Iterator<String> itemsForDiscover = planet.getItems().iterator();

        boolean flag = false;

        for (Astronaut astronaut : astronauts) {

            while (astronaut.canBreath() && itemsForDiscover.hasNext()) {

                astronaut.breath();
                String currentItem = itemsForDiscover.next();
                astronaut.getBag().getItems().add(currentItem);
                itemsForDiscover.remove();

                if (astronaut.getOxygen() <= 0 || !itemsForDiscover.hasNext()) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

    }
}
