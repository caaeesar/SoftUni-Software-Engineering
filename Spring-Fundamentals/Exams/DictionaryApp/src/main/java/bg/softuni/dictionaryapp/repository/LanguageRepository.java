package bg.softuni.dictionaryapp.repository;

import bg.softuni.dictionaryapp.model.entity.Language;
import bg.softuni.dictionaryapp.model.entity.enums.LanguageName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, String> {

    Language getLanguageByName(LanguageName name);

}
