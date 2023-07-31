package bg.softuni.productsshop.model.dto.userDtos;

import bg.softuni.productsshop.model.dto.productDtos.ProductCountWrapperDto;

public class UserWithSoldProductsDto {

    private String firstName;
    private String lastName;
    private int age;
    private ProductCountWrapperDto soldProducts;

    public UserWithSoldProductsDto() {
    }

    public UserWithSoldProductsDto(String firstName, String lastName, int age, ProductCountWrapperDto soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.soldProducts = soldProducts;
    }

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

    public ProductCountWrapperDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductCountWrapperDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
