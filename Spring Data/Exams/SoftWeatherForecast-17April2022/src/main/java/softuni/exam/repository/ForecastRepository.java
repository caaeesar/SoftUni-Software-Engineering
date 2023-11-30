package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.entity.enums.DayOfWeek;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {

    Optional<Forecast> findForecastByDayOfWeekAndCity_Id(DayOfWeek dayOfWeek, Long cityId);
    List<Forecast> findForecastsByDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek dayOfWeek, Integer lowerBound);

}
