package bg.softuni.dictionaryapp.service.impl;

import bg.softuni.dictionaryapp.model.entity.Language;
import bg.softuni.dictionaryapp.model.entity.enums.LanguageName;
import bg.softuni.dictionaryapp.repository.LanguageRepository;
import bg.softuni.dictionaryapp.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void seedLanguages() {
        if (languageRepository.count() != 0) {
            return;
        }

        List<Language> languages = Arrays.stream(LanguageName.values()).map(languageName -> {
            Language language = new Language(languageName);
            switch (languageName) {
                case GERMAN ->
                        language.setDescription("A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.");
                case SPANISH ->
                        language.setDescription("A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure");
                case FRENCH ->
                        language.setDescription("A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.");
                case ITALIAN ->
                        language.setDescription("A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.");
            }
            return language;
        }).toList();
        languageRepository.saveAll(languages);
    }
}
