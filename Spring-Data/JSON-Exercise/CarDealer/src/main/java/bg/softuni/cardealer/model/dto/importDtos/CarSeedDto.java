package bg.softuni.cardealer.model.dto.importDtos;


import java.util.List;

public class CarSeedDto {

    private String make;
    private String model;
    private long travelledDistance;
    private List<PartSeedDto> parts;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<PartSeedDto> getParts() {
        return parts;
    }

    public void setParts(List<PartSeedDto> parts) {
        this.parts = parts;
    }
}
