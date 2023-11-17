package bg.softuni.likebookapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post extends BaseEntity {

    @Column(columnDefinition = "TEXT", nullable = false)
    @Size(min = 2, max = 150)
    @NotBlank
    private String content;

    @ManyToOne
    @NotNull
    private User creator;

    @ManyToMany
    @JoinTable(
            name = "users_likes_posts",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")

    )
    private Set<User> userLikes = new HashSet<>();

    @ManyToOne
    @NotNull
    private Mood mood;

}
