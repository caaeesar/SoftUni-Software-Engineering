package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "offer")
public class OfferSeedDto {

    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;

    @XmlElement
    private AgentWithNameDto agent;

    @XmlElement
    private ApartmentWithId apartment;

    @XmlElement
    @NotNull
    private String publishedOn;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentWithNameDto getAgent() {
        return agent;
    }

    public void setAgent(AgentWithNameDto agent) {
        this.agent = agent;
    }

    public ApartmentWithId getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentWithId apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
