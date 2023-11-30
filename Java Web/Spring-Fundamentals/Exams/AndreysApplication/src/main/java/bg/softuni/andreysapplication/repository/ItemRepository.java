package bg.softuni.andreysapplication.repository;

import bg.softuni.andreysapplication.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    Optional<Item> findItemByName(String name);

    Item getItemById(String id);

}
