package softuni.exam.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
