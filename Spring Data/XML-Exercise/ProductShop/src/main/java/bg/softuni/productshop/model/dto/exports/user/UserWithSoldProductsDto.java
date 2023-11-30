package bg.softuni.productshop.model.dto.exports.user;

import bg.softuni.productshop.model.dto.exports.product.ProductInfoDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class UserWithSoldProductsDto {

    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private int age;
    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private List<ProductInfoDto> soldProducts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ProductInfoDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductInfoDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
