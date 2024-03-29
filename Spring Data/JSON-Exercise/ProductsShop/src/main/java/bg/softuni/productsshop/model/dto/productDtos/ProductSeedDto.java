package bg.softuni.productsshop.model.dto.productDtos;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProductSeedDto {
    @Expose
    @Size(min = 3)
    private String name;
    @Expose
    private BigDecimal price;

    public ProductSeedDto() {
    }

    public ProductSeedDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
