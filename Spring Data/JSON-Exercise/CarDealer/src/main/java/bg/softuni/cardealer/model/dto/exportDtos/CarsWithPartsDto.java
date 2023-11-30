package bg.softuni.cardealer.model.dto.exportDtos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarsWithPartsDto {

    @SerializedName("Make")
    private String make;
    @SerializedName("Model")
    private String model;
    @SerializedName("TravelledDistance")
    private long travelledDistance;
    private List<PartWithNameAndPriceDto> parts;

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

    public List<PartWithNameAndPriceDto> getParts() {
        return parts;
    }

    public void setParts(List<PartWithNameAndPriceDto> parts) {
        this.parts = parts;
    }
}
