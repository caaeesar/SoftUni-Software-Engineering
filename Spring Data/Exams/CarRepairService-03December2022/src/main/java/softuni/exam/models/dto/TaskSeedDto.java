package softuni.exam.models.dto;


import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "task")
public class TaskSeedDto {

    @XmlElement
    @Positive
    private BigDecimal price;
    @XmlElement
    private String date;
    @XmlElement
    private MechanicWithNameDto mechanic;
    @XmlElement
    private PartWithIdDto part;
    @XmlElement
    private CarWithIdDto car;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MechanicWithNameDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicWithNameDto mechanic) {
        this.mechanic = mechanic;
    }

    public PartWithIdDto getPart() {
        return part;
    }

    public void setPart(PartWithIdDto part) {
        this.part = part;
    }

    public CarWithIdDto getCar() {
        return car;
    }

    public void setCar(CarWithIdDto car) {
        this.car = car;
    }
}
