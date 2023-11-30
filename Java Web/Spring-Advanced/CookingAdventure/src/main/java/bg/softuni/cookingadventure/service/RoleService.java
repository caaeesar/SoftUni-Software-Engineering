package bg.softuni.cookingadventure.service;

import bg.softuni.cookingadventure.model.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    void seedRoles();

    List<RoleEntity> getAllRoles();
}
