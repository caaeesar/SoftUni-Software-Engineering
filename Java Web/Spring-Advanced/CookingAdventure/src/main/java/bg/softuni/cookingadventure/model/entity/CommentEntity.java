package bg.softuni.cookingadventure.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
public class CommentEntity extends BaseEntity {

    @ManyToOne
    private UserEntity author;

    @Column(name = "date_time_post")
    private LocalDateTime dateTimePost;

    @Column(columnDefinition = "TEXT", length = 1)
    private String text;

    @ManyToOne
    private RecipeEntity recipe;
}
