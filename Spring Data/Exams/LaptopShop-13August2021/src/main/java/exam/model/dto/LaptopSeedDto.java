package exam.model.dto;

import exam.model.entity.enums.WarrantyType;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopSeedDto {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 8)
    private String macAddress;

    @NotNull
    @Positive
    private Double cpuSpeed;

    @NotNull
    @Min(value = 8)
    @Max(value = 128)
    private Integer ram;

    @NotNull
    @Min(value = 128)
    @Max(value = 1024)
    private Integer storage;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 10)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private WarrantyType warrantyType;

    private ShopWithNameDto shop;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
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

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public ShopWithNameDto getShop() {
        return shop;
    }

    public void setShop(ShopWithNameDto shop) {
        this.shop = shop;
    }
}
