package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ticket")
public class TicketSeedDto {

    @XmlElement(name = "serial-number")
    @NotNull
    @Length(min = 2)
    private String serialNumber;

    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;

    @XmlElement(name = "take-off")
    @NotNull
    private String takeOff;

    @XmlElement(name = "from-town")
    @NotNull
    private TownFromDto fromTown;

    @XmlElement(name = "to-town")
    @NotNull
    private TownToDto toTown;

    @XmlElement
    @NotNull
    private PassengerWithEmailDto passenger;

    @XmlElement
    @NotNull
    private PlaneWithRegisterNumberDto plane;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public TownFromDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(TownFromDto fromTown) {
        this.fromTown = fromTown;
    }

    public TownToDto getToTown() {
        return toTown;
    }

    public void setToTown(TownToDto toTown) {
        this.toTown = toTown;
    }

    public PassengerWithEmailDto getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerWithEmailDto passenger) {
        this.passenger = passenger;
    }

    public PlaneWithRegisterNumberDto getPlane() {
        return plane;
    }

    public void setPlane(PlaneWithRegisterNumberDto plane) {
        this.plane = plane;
    }
}
