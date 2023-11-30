package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "positions")
public class Position {

    @Id
    @Column(nullable = false, length = 3)
    private String id;
    private String description;

}
