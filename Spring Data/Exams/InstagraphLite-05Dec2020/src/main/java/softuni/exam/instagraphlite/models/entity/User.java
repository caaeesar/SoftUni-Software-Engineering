package softuni.exam.instagraphlite.models.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @ManyToOne
    @JoinColumn(name = "profile_picture_id")
    @NotNull
    private Picture profilePicture;

    @OneToMany(mappedBy = "user")
    @Fetch(FetchMode.JOIN)
    private List<Post> posts = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
