package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Iterator;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {

        Iterator<Gun> gunIterator = mainPlayer.getGunRepository().getModels().iterator();
        Iterator<Player> civilIterator = civilPlayers.iterator();
        Gun gun;
        Player civilPlayer;

        while (civilIterator.hasNext()) {

            civilPlayer = civilIterator.next();

            while (gunIterator.hasNext()) {

                gun = gunIterator.next();
                while (civilPlayer.isAlive()) {
                civilPlayer.takeLifePoints(gun.fire());

                    if (gun.getTotalBullets() == 0) {
                        break;
                    }

                }

            }

        }

        while (mainPlayer.isAlive() && civilIterator.hasNext()) {

            civilPlayer = civilIterator.next();
            Iterator<Gun> civilGunIterator = civilPlayer.getGunRepository().getModels().iterator();

            while (civilGunIterator.hasNext()) {

                gun = civilGunIterator.next();
                mainPlayer.takeLifePoints(gun.fire());

                if (gun.getTotalBullets() == 0) {
                    civilGunIterator.remove();
                }

                if (!mainPlayer.isAlive()) {
                    break;
                }
            }
        }

    }
}
