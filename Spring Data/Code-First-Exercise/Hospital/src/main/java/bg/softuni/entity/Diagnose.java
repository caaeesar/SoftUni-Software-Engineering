package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
    private LocalDate date;
    private String comments;
    @ManyToMany(mappedBy = "diagnoses", targetEntity = Patient.class,cascade = CascadeType.MERGE)
    private List<Patient> patients;

    public Diagnose() {
        this.patients = new ArrayList<>();
    }
}
