package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cars")
public class CarRootWithMakeToyotaDto {

    @XmlElement(name = "car")
    private List<CarWithMakeToyotaDto> cars;

    public List<CarWithMakeToyotaDto> getCars() {
        return cars;
    }

    public void setCars(List<CarWithMakeToyotaDto> cars) {
        this.cars = cars;
    }
}
