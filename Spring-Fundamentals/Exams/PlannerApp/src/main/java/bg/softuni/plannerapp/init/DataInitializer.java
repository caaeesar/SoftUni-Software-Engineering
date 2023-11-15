package bg.softuni.plannerapp.init;

import bg.softuni.plannerapp.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PriorityService priorityService;

    @Autowired
    public DataInitializer(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @Override
    public void run(String... args) throws Exception {
        priorityService.seedPriorities();
    }
}
