package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerWithSaleDto {

    @XmlAttribute(name = "full-name")
    private String fullName;
    @XmlAttribute(name = "bought-cars")
    private long boughtCars;
    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    public CustomerWithSaleDto() {
    }

    public CustomerWithSaleDto(String fullName, long boughtCars, BigDecimal spentMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spentMoney = spentMoney;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(long boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }
}
