package exam.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {

    @NotNull
    @Column(unique = true)
    private String address;

    @NotNull
    @Column(name = "employee_count")
    private Integer employeeCount;

    @NotNull
    private BigDecimal income;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "shop_area")
    private Integer shopArea;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;


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

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
