package bg.softuni.dictionaryapp.repository;

import bg.softuni.dictionaryapp.model.entity.Word;
import bg.softuni.dictionaryapp.model.entity.enums.LanguageName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {

    List<Word> getWordsByLanguage_Name(LanguageName name);

}
