package bg.softuni.productshop.model.dto.exports.user;

import bg.softuni.productshop.model.dto.exports.product.ProductCountWrapperDto;
import bg.softuni.productshop.model.dto.exports.product.ProductNameAndPriceDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.stream.Collectors;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class UserWrapperDto {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private int age;

    private List<ProductNameAndPriceDto> soldProducts;

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

    public List<ProductNameAndPriceDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductNameAndPriceDto> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public UserSoldProductsDto createUserWithSoldProductsDto() {
        return new UserSoldProductsDto(this.firstName, this.lastName, this.age, createProductsSoldWithCountDto());
    }

    public ProductCountWrapperDto createProductsSoldWithCountDto() {
        return new ProductCountWrapperDto(
                this.soldProducts.stream()
                        .map(this::createProductNameAndPriceDto)
                        .collect(Collectors.toList())
        );
    }
    public ProductNameAndPriceDto createProductNameAndPriceDto(ProductNameAndPriceDto product) {
        return new ProductNameAndPriceDto(product.getName(), product.getPrice());
    }

}

