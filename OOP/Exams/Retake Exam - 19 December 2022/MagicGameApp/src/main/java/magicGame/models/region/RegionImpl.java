package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {

        List<Magician> wizardTeam = new ArrayList<>();
        List<Magician> blackWidowTeam = new ArrayList<>();

        for (Magician magician : magicians) {
            if (magician.getClass().getSimpleName().equals("Wizard")) {
                wizardTeam.add(magician);
            } else if (magician.getClass().getSimpleName().equals("BlackWidow")) {
                blackWidowTeam.add(magician);
            }
        }

        while(!wizardTeam.isEmpty() && !blackWidowTeam.isEmpty()){
            Wizard wizard = (Wizard) wizardTeam.get(0);
            BlackWidow blackWidow = (BlackWidow) blackWidowTeam.get(0);

            int wizDamagePoints = wizard.getMagic().fire();
            blackWidow.takeDamage(wizDamagePoints);
            if (blackWidow.isAlive()){
                int blackDamagePoints = blackWidow.getMagic().fire();
                wizard.takeDamage(blackDamagePoints);
                if (!wizard.isAlive()){
                    wizardTeam.remove(wizard);
                }
            } else {
                blackWidowTeam.remove(blackWidow);
            }
        }
        if (wizardTeam.size() > blackWidowTeam.size()){
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
