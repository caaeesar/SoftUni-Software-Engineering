package com.example.resellerapp.init;

import com.example.resellerapp.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ConditionService conditionService;

    @Autowired
    public DatabaseInit(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public void run(String... args) throws Exception {
        conditionService.seedConditions();
    }
}
