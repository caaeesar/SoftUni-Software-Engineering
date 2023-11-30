package bg.softuni.usersystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "towns")
@Getter
@Setter
@NoArgsConstructor
public class Town extends BaseEntity{


    private String name;
    @ManyToOne
    private Country country;


}
