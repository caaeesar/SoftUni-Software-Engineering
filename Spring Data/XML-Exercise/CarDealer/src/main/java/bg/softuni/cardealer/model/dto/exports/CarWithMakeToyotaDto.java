package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class CarWithMakeToyotaDto {

    @XmlAttribute(name = "id")
    private Long id;
    @XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private long travelledDistance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
