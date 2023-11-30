package com.example.mobilelelewebapplication.repository;

import com.example.mobilelelewebapplication.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    ModelEntity getById(Long id);

}
