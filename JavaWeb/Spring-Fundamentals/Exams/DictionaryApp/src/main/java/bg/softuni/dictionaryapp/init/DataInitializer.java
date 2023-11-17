package bg.softuni.dictionaryapp.init;

import bg.softuni.dictionaryapp.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LanguageService languageService;

    @Autowired
    public DataInitializer(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Override
    public void run(String... args) throws Exception {
        languageService.seedLanguages();
    }
}
