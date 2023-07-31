package bg.softuni.automappingobjectsexercise.dao;

import bg.softuni.automappingobjectsexercise.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findGameByTitle(String title);
    Game getGameByTitle(String title);

}
