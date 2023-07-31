package exam.model.dto;

import java.math.BigDecimal;

public class LaptopExportDto {

    private String macAddress;

    private Double cpuSpeed;

    private Integer ram;

    private Integer storage;

    private BigDecimal price;

    private ShopNameAndTownNameExportDto shop;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ShopNameAndTownNameExportDto getShop() {
        return shop;
    }

    public void setShop(ShopNameAndTownNameExportDto shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        String format = "Laptop - %s\n*Cpu speed - %.2f\n**Ram - %d\n***Storage - %d\n****Price - %s\n#Shop name - %s\n##Town - %s";
        return String.format(format, getMacAddress(), getCpuSpeed(), getRam(), getStorage(), getPrice().setScale(2), getShop().getName(), getShop().getTownName());
    }
}
