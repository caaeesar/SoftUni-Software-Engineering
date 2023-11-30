package exam.model.dto;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "shop")
public class ShopSeedDto {

    @XmlElement
    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 4)
    private String name;
    @XmlElement
    @NotNull
    @DecimalMin(value = "20000.00")
    private BigDecimal income;
    @XmlElement
    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 4)
    private String address;

    @XmlElement(name = "employee-count")
    @NotNull
    @Min(value = 1)
    @Max(value = 50)
    private Integer employeeCount;

    @XmlElement(name = "shop-area")
    @NotNull
    @Min(value = 150)
    private Integer shopArea;

    @XmlElement
    private TownWithNameDto town;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShopArea() {
        return shopArea;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }

    public TownWithNameDto getTown() {
        return town;
    }

    public void setTown(TownWithNameDto town) {
        this.town = town;
    }
}
