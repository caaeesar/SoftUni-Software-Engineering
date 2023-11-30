package bg.softuni.core;

import javax.persistence.EntityManager;

public interface Executable {

    String execute(EntityManager entityManager);
}
