package bg.softuni.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String email;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(columnDefinition = "BLOB")
    private byte[] picture;
    @Column(name = "is_has_insurance")
    private boolean isHasInsurance;

    @OneToMany
    private List<Visitation> visitations;
    @ManyToMany(fetch = FetchType.LAZY) // data is extracted only as necessary
    @JoinTable(
            name = "patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id")
    )
    private List<Diagnose> diagnoses;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "patients_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medical_id", referencedColumnName = "id")
    )
    private List<Medicament> medicaments;

    public Patient() {

    }

    public Patient(String firstName) {
        this.firstName = firstName;
        this.visitations = new ArrayList<>();
        this.diagnoses = new ArrayList<>();
        this.medicaments = new ArrayList<>();
    }

}
