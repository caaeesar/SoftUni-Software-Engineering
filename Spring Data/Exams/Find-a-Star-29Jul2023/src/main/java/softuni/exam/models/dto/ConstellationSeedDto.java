package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ConstellationSeedDto {

    @NotNull
    @Length(min = 3, max = 20)
    private String name;

    @NotNull
    @Length(min = 5)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
