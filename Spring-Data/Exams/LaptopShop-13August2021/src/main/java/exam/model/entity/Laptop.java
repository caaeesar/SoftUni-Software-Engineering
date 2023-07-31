package exam.model.entity;

import exam.model.entity.enums.WarrantyType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

    @NotNull
    @Column(name = "cpu_speed")
    private Double cpuSpeed;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Column(name = "mac_address", unique = true)
    private String macAddress;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer ram;

    @NotNull
    private Integer storage;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "warranty_type")
    private WarrantyType warrantyType;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;


    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
