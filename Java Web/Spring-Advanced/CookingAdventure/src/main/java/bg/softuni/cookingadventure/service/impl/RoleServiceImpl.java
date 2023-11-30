package bg.softuni.cookingadventure.service.impl;

import bg.softuni.cookingadventure.model.entity.RoleEntity;
import bg.softuni.cookingadventure.model.entity.enums.RoleName;
import bg.softuni.cookingadventure.repository.RoleRepository;
import bg.softuni.cookingadventure.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRoles() {
        if (roleRepository.count() != 0) {
            return;
        }

        List<RoleEntity> roleEntities = Arrays.stream(RoleName.values()).map(RoleEntity::new).collect(Collectors.toList());
        roleRepository.saveAll(roleEntities);
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }
}
