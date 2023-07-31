package bg.softuni.automappingobjectslab.dao;

import bg.softuni.automappingobjectslab.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
