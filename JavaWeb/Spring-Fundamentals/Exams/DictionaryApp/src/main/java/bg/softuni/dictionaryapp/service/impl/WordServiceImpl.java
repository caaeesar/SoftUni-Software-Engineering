package bg.softuni.dictionaryapp.service.impl;

import bg.softuni.dictionaryapp.model.entity.Language;
import bg.softuni.dictionaryapp.model.entity.User;
import bg.softuni.dictionaryapp.model.entity.Word;
import bg.softuni.dictionaryapp.model.entity.enums.LanguageName;
import bg.softuni.dictionaryapp.model.service.WordServiceModel;
import bg.softuni.dictionaryapp.model.view.*;
import bg.softuni.dictionaryapp.repository.LanguageRepository;
import bg.softuni.dictionaryapp.repository.UserRepository;
import bg.softuni.dictionaryapp.repository.WordRepository;
import bg.softuni.dictionaryapp.service.WordService;
import bg.softuni.dictionaryapp.session.SessionUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final SessionUser sessionUser;
    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WordServiceImpl(SessionUser sessionUser, WordRepository wordRepository, UserRepository userRepository, LanguageRepository languageRepository, ModelMapper modelMapper) {
        this.sessionUser = sessionUser;
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.languageRepository = languageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createWord(WordServiceModel wordServiceModel) {
        Word word = modelMapper.map(wordServiceModel, Word.class);
        Language language = languageRepository.getLanguageByName(wordServiceModel.getLanguage());
        word.setLanguage(language);
        User user = userRepository.findUserByUsername(sessionUser.getUsername()).get();
        word.setAddedBy(user);
        user.getAddedWords().add(word);
        wordRepository.save(word);
        userRepository.save(user);
    }

    @Override
    public int getAllWords() {
        return wordRepository.findAll().size();
    }

    @Override
    public HomeWordsViewModel findAllWordsForHomePage() {
        List<GermanWordsViewModel> germanWords = wordRepository.getWordsByLanguage_Name(LanguageName.GERMAN)
                .stream().map(word -> modelMapper.map(word, GermanWordsViewModel.class)).toList();

        List<SpanishWordsViewModel> spanishWords = wordRepository.getWordsByLanguage_Name(LanguageName.SPANISH)
                .stream().map(word -> modelMapper.map(word, SpanishWordsViewModel.class)).toList();

        List<FrenchWordsViewModel> frenchWords = wordRepository.getWordsByLanguage_Name(LanguageName.FRENCH)
                .stream().map(word -> modelMapper.map(word, FrenchWordsViewModel.class)).toList();

        List<ItalianWordsViewModel> italianWords = wordRepository.getWordsByLanguage_Name(LanguageName.ITALIAN)
                .stream().map(word -> modelMapper.map(word, ItalianWordsViewModel.class)).toList();

        return new HomeWordsViewModel(germanWords,spanishWords,frenchWords,italianWords);
    }

    @Override
    public void removeAllWords() {
        List<Word> allWords = wordRepository.findAll();
        for (int i = 0; i < allWords.size(); i++) {
            Word word = allWords.get(i);
            User user = word.getAddedBy();
            user.getAddedWords().remove(word);
            userRepository.save(user);
        }
        wordRepository.deleteAll();
    }

    @Override
    public void removeWordById(String id) {
        Word word = wordRepository.findById(id).get();
        User user = word.getAddedBy();
        user.getAddedWords().remove(word);
        userRepository.save(user);
        wordRepository.deleteById(id);
    }
}
