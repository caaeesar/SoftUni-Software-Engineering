package softuni.exam.models.dto;

public class ApartmentWithAreaAndTownDto {

    private Double area;
    private TownWithNameDto town;

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public TownWithNameDto getTown() {
        return town;
    }

    public void setTown(TownWithNameDto town) {
        this.town = town;
    }
}
