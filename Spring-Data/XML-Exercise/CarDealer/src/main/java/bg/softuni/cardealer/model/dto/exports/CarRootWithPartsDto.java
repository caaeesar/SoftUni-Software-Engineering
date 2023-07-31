package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cars")
public class CarRootWithPartsDto {

    @XmlElement(name = "car")
   private List<CarWithPartsDto> cars;

    public List<CarWithPartsDto> getCars() {
        return cars;
    }

    public void setCars(List<CarWithPartsDto> cars) {
        this.cars = cars;
    }
}
