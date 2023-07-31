package bg.softuni.cardealer.model.dto.exportDtos;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

public class CustomerOrderedDto {

    @SerializedName("Id")
    private long id;
    @SerializedName("Name")
    private String name;
    @SerializedName("BirthDate")
    private LocalDate birthDate;
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;
    @SerializedName("Sales")
    private List<SaleInfoDto> sales;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public List<SaleInfoDto> getSales() {
        return sales;
    }

    public void setSales(List<SaleInfoDto> sales) {
        this.sales = sales;
    }
}
