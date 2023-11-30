package bg.softuni.cardealer.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity {

    private String name;
    @Column(name = "is_importer")
    private boolean isImporter;
    @OneToMany(mappedBy = "supplier", targetEntity = Part.class, fetch = FetchType.EAGER)
    private List<Part> parts = new ArrayList<>();

    public int getPartsCount() {
        return this.parts.size();
    }
}
