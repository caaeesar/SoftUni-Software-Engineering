package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private LocalDate date;
    private String comments;

}
