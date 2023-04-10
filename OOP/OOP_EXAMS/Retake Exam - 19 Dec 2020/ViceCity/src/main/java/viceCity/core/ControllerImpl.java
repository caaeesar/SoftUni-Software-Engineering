package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.GunRepository;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Player mainPlayer;
    private Collection<Player> civilPlayersRepo;
    private Repository<Gun> gunsRepo;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayersRepo = new ArrayList<>();
        this.gunsRepo = new GunRepository();
    }

    @Override
    public String addPlayer(String name) {
        Player civil = new CivilPlayer(name);
        this.civilPlayersRepo.add(civil);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        this.gunsRepo.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = this.gunsRepo.getModels().stream().findFirst().orElse(null);
        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")) {
            if (mainPlayer.getGunRepository().getModels().stream().filter(g -> g.equals(gun)).findFirst().orElse(null) == null) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), name);
            }
        }

        Player civil = this.civilPlayersRepo.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (civil == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        civil.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {

        StringBuilder out = new StringBuilder();

        int initCivilPlayers = this.civilPlayersRepo.size();

        Neighbourhood hood = new GangNeighbourhood();
        hood.action(mainPlayer, this.civilPlayersRepo);

        long aliveCount = this.civilPlayersRepo.stream().filter(Player::isAlive).count();

        if (mainPlayer.getLifePoints() == 100 && aliveCount == initCivilPlayers) {
            return FIGHT_HOT_HAPPENED;
        } else {
        long deadCivilPlayers = this.civilPlayersRepo.stream().filter(p -> !p.isAlive()).count();
        out.append(FIGHT_HAPPENED).append(System.lineSeparator());
        out.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
        out.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilPlayers)).append(System.lineSeparator());
        out.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, this.civilPlayersRepo.size() - deadCivilPlayers)).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
