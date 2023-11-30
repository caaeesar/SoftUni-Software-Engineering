package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class TownSeedDto {

    @Expose
    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 2)
    private String name;

    @Expose
    @NotNull
    @Positive
    private Integer population;

    @Expose
    @NotNull
    @NotEmpty
    @NotBlank
    private String guide;

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

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
