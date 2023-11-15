package com.example.resellerapp.repository;

import com.example.resellerapp.model.entity.Condition;
import com.example.resellerapp.model.entity.enums.ConditionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, String> {

    Condition getConditionByName(ConditionName name);

}
