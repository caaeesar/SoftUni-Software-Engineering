package bg.softuni.cookingadventure.model.view;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentViewModel {

    private Long id;

    private UserProfileViewModel author;

    private LocalDateTime dateTimePost;

    private String text;
}
