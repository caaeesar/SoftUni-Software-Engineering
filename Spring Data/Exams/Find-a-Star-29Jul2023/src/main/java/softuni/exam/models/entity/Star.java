package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.StarType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "light_years", nullable = false)
    private Double lightYears;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StarType starType;

    @ManyToOne
    @JoinColumn(name = "constellation_id")
    private Constellation constellation;

    @OneToMany(mappedBy = "observingStar")
    private List<Astronomer> observers = new ArrayList<>();

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public List<Astronomer> getObservers() {
        return observers;
    }

    public void setObservers(List<Astronomer> observers) {
        this.observers = observers;
    }
}
