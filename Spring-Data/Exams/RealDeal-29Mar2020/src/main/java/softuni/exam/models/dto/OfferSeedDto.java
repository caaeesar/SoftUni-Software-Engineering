package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "offer")
public class OfferSeedDto {

    @XmlElement
    @Length(min = 5)
    private String description;

    @XmlElement
    @Positive
    private BigDecimal price;

    @XmlElement(name = "added-on")
    private String addedOn;

    @XmlElement(name = "has-gold-status")
    private Boolean hasGoldStatus;

    @XmlElement
    private CarWithIdDto car;

    @XmlElement
    private SellerWithIdDto seller;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public CarWithIdDto getCar() {
        return car;
    }

    public void setCar(CarWithIdDto car) {
        this.car = car;
    }

    public SellerWithIdDto getSeller() {
        return seller;
    }

    public void setSeller(SellerWithIdDto seller) {
        this.seller = seller;
    }
}
