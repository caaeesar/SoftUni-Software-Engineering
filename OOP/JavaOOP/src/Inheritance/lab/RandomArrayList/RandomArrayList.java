package Inheritance.lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random rng;

    public Object getRandomElement() {
        rng = new Random();
        int randomIndex = rng.nextInt(super.size() - 1);
        return super.get(randomIndex);
    }

}
