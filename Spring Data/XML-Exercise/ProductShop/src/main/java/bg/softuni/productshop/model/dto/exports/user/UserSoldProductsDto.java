package bg.softuni.productshop.model.dto.exports.user;

import bg.softuni.productshop.model.dto.exports.product.ProductCountWrapperDto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class UserSoldProductsDto {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private int age;
    @XmlElement(name = "sold-products")
    private ProductCountWrapperDto productCountWrapperDto;

    public UserSoldProductsDto() {
    }

    public UserSoldProductsDto(String firstName, String lastName, int age, ProductCountWrapperDto productCountWrapperDto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.productCountWrapperDto = productCountWrapperDto;
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

    public ProductCountWrapperDto getProductBasicInfoDto() {
        return productCountWrapperDto;
    }

    public void setProductBasicInfoDto(ProductCountWrapperDto productCountWrapperDto) {
        this.productCountWrapperDto = productCountWrapperDto;
    }
}
