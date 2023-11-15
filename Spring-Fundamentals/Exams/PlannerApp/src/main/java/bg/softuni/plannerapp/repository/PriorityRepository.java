package bg.softuni.plannerapp.repository;

import bg.softuni.plannerapp.model.entity.Priority;
import bg.softuni.plannerapp.model.entity.enums.PriorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, String> {

    Priority findPriorityByPriorityName(PriorityName priorityName);
}
