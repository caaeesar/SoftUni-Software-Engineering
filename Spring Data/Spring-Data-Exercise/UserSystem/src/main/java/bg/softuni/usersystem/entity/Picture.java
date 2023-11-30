package bg.softuni.usersystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pictures")
@Getter
@Setter
@NoArgsConstructor
public class Picture extends BaseEntity {

    private String title;
    private String caption;
    private String path;



}
