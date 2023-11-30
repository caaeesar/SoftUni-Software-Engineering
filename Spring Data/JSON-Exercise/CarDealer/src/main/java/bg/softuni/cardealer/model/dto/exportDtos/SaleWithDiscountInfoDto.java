package bg.softuni.cardealer.model.dto.exportDtos;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class SaleWithDiscountInfoDto {
    @SerializedName("Make")
    private String make;
    @SerializedName("Model")
    private String model;
    @SerializedName("TravelledDistance")
    private long travelledDistance;
    private String customerName;

    @SerializedName("Discount")
    private double discount;

    private Double price;
    private Double priceWithDiscount;

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

    public Double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(Double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
