package bg.softuni.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT_NAME = "softuni";

    public static EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }
}
