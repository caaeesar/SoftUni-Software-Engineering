package bg.softuni.likebookapp.init;

import bg.softuni.likebookapp.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MoodService moodService;

    @Autowired
    public DataInitializer(MoodService moodService) {
        this.moodService = moodService;
    }

    @Override
    public void run(String... args) throws Exception {
        moodService.seedMood();
    }
}
