package bg.softuni.exercise;

import bg.softuni.entity.Project;

import javax.persistence.EntityManager;
import java.util.Comparator;

public class FindTheLatest10Projects extends Exercise {

    @Override
    public String execute(EntityManager entityManager) {
        StringBuilder out = new StringBuilder();
        entityManager.createQuery("FROM Project ORDER BY startDate DESC")
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> out.append(p).append(System.lineSeparator()));
        return out.toString().trim();
    }
}
