package bg.softuni.dictionaryapp.controller;

import bg.softuni.dictionaryapp.model.binding.WordAddBindingModel;
import bg.softuni.dictionaryapp.model.entity.enums.LanguageName;
import bg.softuni.dictionaryapp.model.service.WordServiceModel;
import bg.softuni.dictionaryapp.service.WordService;
import bg.softuni.dictionaryapp.session.SessionUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/words")
public class WordsController {

    private final SessionUser sessionUser;
    private final WordService wordService;
    private final ModelMapper modelMapper;

    @Autowired
    public WordsController(SessionUser sessionUser, WordService wordService, ModelMapper modelMapper) {
        this.sessionUser = sessionUser;
        this.wordService = wordService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public void addLanguageNames(Model model) {
        model.addAttribute("languages", LanguageName.values());
    }

    @ModelAttribute
    public WordAddBindingModel wordAddBindingModel(){
        return new WordAddBindingModel();
    }

    @GetMapping("/add")
    public String addWord() {
        if (sessionUser.isLogged()) {
            return "word-add";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addWordPost(@Valid WordAddBindingModel wordAddBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("wordAddBindingModel", wordAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.wordAddBindingModel", bindingResult);
            return "redirect:add";
        }

        WordServiceModel wordServiceModel = modelMapper.map(wordAddBindingModel, WordServiceModel.class);
        wordService.createWord(wordServiceModel);
        return "redirect:/";
    }

    @DeleteMapping("/remove/{id}")
    public String removeWord(@PathVariable String id) {
        wordService.removeWordById(id);
        return "redirect:/";
    }

    @DeleteMapping("/removeAll")
    public String removeAll() {
        wordService.removeAllWords();
        return "redirect:/";
    }
}
