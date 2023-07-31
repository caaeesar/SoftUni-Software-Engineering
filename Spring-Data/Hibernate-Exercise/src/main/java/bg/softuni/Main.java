package bg.softuni;

import bg.softuni.core.Engine;
import bg.softuni.utils.JPAUtil;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(JPAUtil.createEntityManager());
        engine.run();
    }
}