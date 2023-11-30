package bg.softuni.dictionaryapp.service;

import bg.softuni.dictionaryapp.model.service.WordServiceModel;
import bg.softuni.dictionaryapp.model.view.HomeWordsViewModel;

public interface WordService {
    void createWord(WordServiceModel wordServiceModel);

    int getAllWords();

    HomeWordsViewModel findAllWordsForHomePage();

    void removeAllWords();

    void removeWordById(String id);
}
