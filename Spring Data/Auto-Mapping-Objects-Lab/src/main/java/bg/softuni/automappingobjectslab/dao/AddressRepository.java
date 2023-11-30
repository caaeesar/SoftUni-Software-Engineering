package bg.softuni.automappingobjectslab.dao;

import bg.softuni.automappingobjectslab.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
