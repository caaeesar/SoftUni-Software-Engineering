package bg.softuni.exercise;

import bg.softuni.entity.Town;

import javax.persistence.EntityManager;

import java.util.List;

import static bg.softuni.common.messages.Output.COUNT_AFFECTED_ROWS;

public class ChangeCasing extends Exercise {

    @Override
    public String execute(EntityManager entityManager) {
        // USING JPQL
        entityManager.getTransaction().begin();

        // 1ви начин
        int affectedRows = entityManager.createQuery("UPDATE Town as t " +
                                                            "SET t.name = upper(t.name) " +
                                                            "WHERE length(t.name) <= 5")
                                        .executeUpdate();


        // 2ри начин
      /*  List<Town> allTowns = entityManager.createQuery("FROM Town", Town.class).getResultList();
        for (Town town : allTowns) {
            if (town.getName().length() > 5) {
                entityManager.detach(town);
            } else {
                town.setName(town.getName().toUpperCase());
                entityManager.persist(town);
            }
        }*/

        entityManager.getTransaction().commit();
        entityManager.close();

        return String.format(COUNT_AFFECTED_ROWS, affectedRows);
    }
}
