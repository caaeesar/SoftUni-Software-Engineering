package bg.softuni.productsshop.model.dto.userDtos;


import bg.softuni.productsshop.model.dto.productDtos.ProductCountWrapperDto;
import bg.softuni.productsshop.model.dto.productDtos.ProductNameAndPriceDto;
import bg.softuni.productsshop.model.dto.productDtos.ProductSoldDto;

import java.util.List;
import java.util.stream.Collectors;

public class UsersInfoDto {

    private String firstName;
    private String lastName;
    private int age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<ProductSoldDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductSoldDto> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public UserWithSoldProductsDto createUserWithSoldProductsDto() {
        return new UserWithSoldProductsDto(this.firstName,this.lastName,this.age,createProductsSoldWithCountDto());
    }
    public ProductCountWrapperDto createProductsSoldWithCountDto() {
        return new ProductCountWrapperDto(
                this.soldProducts.stream().map(this::createProductNameAndPriceDto)
                        .collect(Collectors.toList())
        );
    }
    public ProductNameAndPriceDto createProductNameAndPriceDto(ProductSoldDto productSoldDto) {
        return new ProductNameAndPriceDto(productSoldDto.getName(),productSoldDto.getPrice());
    }
}
