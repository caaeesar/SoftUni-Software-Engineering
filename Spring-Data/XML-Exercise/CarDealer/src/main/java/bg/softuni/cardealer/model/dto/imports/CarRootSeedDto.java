package bg.softuni.cardealer.model.dto.imports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cars")
public class CarRootSeedDto {

    @XmlElement(name = "car")
    private List<CarSeedDto> cars;

    public List<CarSeedDto> getCars() {
        return cars;
    }

    public void setCars(List<CarSeedDto> cars) {
        this.cars = cars;
    }
}
