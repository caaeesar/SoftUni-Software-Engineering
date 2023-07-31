package bg.softuni.productshop.model.dto.exports.product;

import bg.softuni.productshop.model.dto.exports.product.ProductInRangeDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "products")
public class ProductRootInRangeDto {

    @XmlElement(name = "product")
    private List<ProductInRangeDto> products;

    public List<ProductInRangeDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeDto> products) {
        this.products = products;
    }
}
