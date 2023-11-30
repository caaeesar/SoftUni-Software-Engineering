package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "car")
public class CarWithPartsDto {

    @XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private long travelledDistance;
    @XmlElementWrapper(name = "parts")
    @XmlElement(name = "part")
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
