package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.enums.StarType;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Optional<Star> findStarByName(String name);

    Optional<Star> findStarById(Long id);

    @Query("SELECT s FROM Star AS s WHERE s.starType = :starType AND SIZE(s.observers) = 0 ORDER BY s.lightYears ASC")
    List<Star> getRedGiantsWithoutObservers(@Param("starType") StarType starType);

}
