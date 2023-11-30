package bg.softuni.productsshop.model.dto.userDtos;


import bg.softuni.productsshop.model.dto.productDtos.ProductSoldDto;
import com.google.gson.annotations.Expose;

import java.util.List;

public class UserSoldDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;

    @Expose
    private List<ProductSoldDto> soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductSoldDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductSoldDto> soldProducts) {
        this.soldProducts = soldProducts;
    }

}
