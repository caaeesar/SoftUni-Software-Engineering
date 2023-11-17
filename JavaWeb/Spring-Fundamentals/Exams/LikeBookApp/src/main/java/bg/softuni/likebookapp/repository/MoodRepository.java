package bg.softuni.likebookapp.repository;

import bg.softuni.likebookapp.model.entity.Mood;
import bg.softuni.likebookapp.model.entity.enums.MoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends JpaRepository<Mood, String> {

    Mood getMoodByName(MoodType name);

}
