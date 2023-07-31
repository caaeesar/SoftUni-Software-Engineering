package bg.softuni.cardealer.model.dto.exports;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sale")
public class SaleWithDiscountInfoDto {

    @XmlAttribute(name = "make")
    private String make;
    @XmlAttribute(name = "model")
    private String model;
    @XmlAttribute(name = "travelled-distance")
    private long travelledDistance;
    @XmlElement(name = "customer-name")
    private String customerName;
    @XmlElement(name = "discount")
    private double discount;
    @XmlElement(name = "price")
    private Double price;
    @XmlElement(name = "price-with-discount")
    private Double priceWithDiscount;

    public SaleWithDiscountInfoDto() {
    }

    public SaleWithDiscountInfoDto(String make, String model, long travelledDistance, String customerName, double discount, Double price, Double priceWithDiscount) {
        this.make = make;
        this.model = model;
        this.travelledDistance = travelledDistance;
        this.customerName = customerName;
        this.discount = discount;
        this.price = price;
        this.priceWithDiscount = priceWithDiscount;
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public Double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(Double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public CarDto createCarDto() {
        return new CarDto(getMake(), getModel(), getTravelledDistance());
    }

    public SaleWrapperDto createSaleWrapper() {
        return new SaleWrapperDto(createCarDto(),getCustomerName(),getDiscount(),getPrice(),getPriceWithDiscount());
    }

}
