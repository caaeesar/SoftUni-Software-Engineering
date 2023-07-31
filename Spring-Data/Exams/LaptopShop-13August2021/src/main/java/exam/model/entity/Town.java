package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    private Integer population;
    @NotNull
    @Column(columnDefinition = "TEXT", name = "travel_guide")
    private String travelGuide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }
}
