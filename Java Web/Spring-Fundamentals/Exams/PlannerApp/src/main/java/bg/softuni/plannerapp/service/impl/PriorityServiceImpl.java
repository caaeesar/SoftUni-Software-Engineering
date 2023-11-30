package bg.softuni.plannerapp.service.impl;

import bg.softuni.plannerapp.model.entity.Priority;
import bg.softuni.plannerapp.model.entity.enums.PriorityName;
import bg.softuni.plannerapp.repository.PriorityRepository;
import bg.softuni.plannerapp.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void seedPriorities() {
        if (priorityRepository.count() != 0) {
            return;
        }

        List<Priority> priorities = Arrays.stream(PriorityName.values()).map(priorityName -> {
            Priority priority = new Priority(priorityName);
            switch (priorityName) {
                case URGENT ->
                        priority.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                case IMPORTANT ->
                        priority.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                case LOW -> priority.setDescription("Should be fixed if time permits but can be postponed.");
            }
            return priority;
        }).toList();

        priorityRepository.saveAll(priorities);
    }
}
