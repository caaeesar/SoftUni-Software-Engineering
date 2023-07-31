package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sale")
public class SaleWrapperDto {

    @XmlElement(name = "car")
    private CarDto carDto;
    @XmlElement(name = "customer-name")
    private String customerName;
    @XmlElement(name = "discount")
    private double discount;
    @XmlElement(name = "price")
    private Double price;
    @XmlElement(name = "price-with-discount")
    private Double priceWithDiscount;

    public SaleWrapperDto() {
    }

    public SaleWrapperDto(CarDto carDto, String customerName, double discount, Double price, Double priceWithDiscount) {
        this.carDto = carDto;
        this.customerName = customerName;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
    }

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(Double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
