package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "rounds")
public class Round extends BaseEntity {

    private String name;

}
