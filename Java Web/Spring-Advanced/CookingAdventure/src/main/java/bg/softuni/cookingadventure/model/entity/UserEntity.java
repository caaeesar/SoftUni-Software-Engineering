package bg.softuni.cookingadventure.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false, unique = true)
    @Size(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    @Size(max = 70)
    private String firstName;

    @Column
    @Size(max = 70)
    private String lastName;

    @Column
    @Positive
    private int age;

    @ManyToMany
    @JoinTable(
            name = "users__favorite_recipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private Set<RecipeEntity> favoriteRecipes = new HashSet<>();

    @OneToMany(mappedBy = "author", targetEntity = RecipeEntity.class)
    private List<RecipeEntity> createdRecipes = new ArrayList<>();

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();
}
