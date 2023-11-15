package bg.softuni.dictionaryapp.model.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HomeWordsViewModel {


    private List<GermanWordsViewModel> germanWords;

    private List<SpanishWordsViewModel> spanishWords;

    private List<FrenchWordsViewModel> frenchWords;

    private List<ItalianWordsViewModel> italianWords;
    public HomeWordsViewModel(List<GermanWordsViewModel> germanWords, List<SpanishWordsViewModel> spanishWords, List<FrenchWordsViewModel> frenchWords, List<ItalianWordsViewModel> italianWords) {
        this.germanWords = germanWords;
        this.spanishWords = spanishWords;
        this.frenchWords = frenchWords;
        this.italianWords = italianWords;
    }
}
