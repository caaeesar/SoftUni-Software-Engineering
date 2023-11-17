package com.example.resellerapp.service.impl;

import com.example.resellerapp.model.entity.Condition;
import com.example.resellerapp.model.entity.enums.ConditionName;
import com.example.resellerapp.repository.ConditionRepository;
import com.example.resellerapp.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionServiceImpl implements ConditionService {

    public static final String EXCELLENT_DESCRIPTION = "In perfect condition";
    public static final String GOOD_DESCRIPTION = "Some signs of wear and tear or minor defects";
    public static final String ACCEPTABLE_DESCRIPTION = "The item is fairly worn but continues to function properly";
    private final ConditionRepository conditionRepository;

    @Autowired
    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void seedConditions() {
        if (conditionRepository.count() != 0) {
            return;
        }

        Arrays.stream(ConditionName.values())
                .forEach(conditionName -> {
                    Condition condition = new Condition();
                    condition.setName(conditionName);
                    switch (conditionName) {
                        case EXCELLENT -> condition.setDescription(EXCELLENT_DESCRIPTION);
                        case GOOD -> condition.setDescription(GOOD_DESCRIPTION);
                        case ACCEPTABLE -> condition.setDescription(ACCEPTABLE_DESCRIPTION);
                    }
                    conditionRepository.save(condition);
                });

    }
}
