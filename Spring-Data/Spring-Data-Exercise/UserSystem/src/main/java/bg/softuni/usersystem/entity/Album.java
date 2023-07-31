package bg.softuni.usersystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "albums")
@Setter
@Getter
@NoArgsConstructor
public class Album extends BaseEntity {

    private String name;
    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "is_public")
    private boolean isPublic;

    @ManyToMany
    private List<Picture> pictures;

}
