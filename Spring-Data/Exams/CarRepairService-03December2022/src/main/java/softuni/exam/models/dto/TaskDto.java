package softuni.exam.models.dto;

import java.math.BigDecimal;

public class TaskDto {

    private Long id;
    private BigDecimal price;
    private CarBasicInfo car;
    private MechanicBasicInfo mechanic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarBasicInfo getCar() {
        return car;
    }

    public void setCar(CarBasicInfo car) {
        this.car = car;
    }

    public MechanicBasicInfo getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicBasicInfo mechanic) {
        this.mechanic = mechanic;
    }

    @Override
    public String toString() {
        String format = "Car %s %s with %dkm\n-Mechanic: %s %s - task №%d:\n --Engine: %.1f\n---Price: %s$";
        return String.format(format, getCar().getCarMake(), getCar().getCarModel(), getCar().getKilometers(),
                getMechanic().getFirstName(), getMechanic().getLastName(),getId(),getCar().getEngine(), getPrice().setScale(2));
    }
}
