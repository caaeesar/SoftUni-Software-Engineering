package bg.softuni.cardealer.model.dto.importDtos;

import java.math.BigDecimal;

public class PartSeedDto {

   private String name;
   private BigDecimal price;
   private long quantity;

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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
