package bg.softuni.cookingadventure.repository;

import bg.softuni.cookingadventure.model.entity.RoleEntity;
import bg.softuni.cookingadventure.model.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity getRoleByName(RoleName name);
}
