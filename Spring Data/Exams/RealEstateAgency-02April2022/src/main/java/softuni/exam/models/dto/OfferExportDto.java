package softuni.exam.models.dto;

import java.math.BigDecimal;

public class OfferExportDto {

    private Long id;
    private AgentWithFullNameDto agent;
    private ApartmentWithAreaAndTownDto apartment;
    private BigDecimal price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AgentWithFullNameDto getAgent() {
        return agent;
    }

    public void setAgent(AgentWithFullNameDto agent) {
        this.agent = agent;
    }

    public ApartmentWithAreaAndTownDto getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentWithAreaAndTownDto apartment) {
        this.apartment = apartment;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String format = "Agent %s %s with offer №%d:\n-Apartment area: %.2f\n--Town: %s\n---Price: %s$";
        return String.format(format, agent.getFirstName(), agent.getLastName(), id, apartment.getArea(), apartment.getTown().getTownName(), price.setScale(2));
    }
}
