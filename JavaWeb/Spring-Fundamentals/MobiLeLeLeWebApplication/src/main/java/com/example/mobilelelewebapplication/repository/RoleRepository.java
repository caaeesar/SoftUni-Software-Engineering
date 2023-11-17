package com.example.mobilelelewebapplication.repository;

import com.example.mobilelelewebapplication.model.entity.RoleEntity;
import com.example.mobilelelewebapplication.model.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

   RoleEntity getByNameIs(RoleType name);

}
