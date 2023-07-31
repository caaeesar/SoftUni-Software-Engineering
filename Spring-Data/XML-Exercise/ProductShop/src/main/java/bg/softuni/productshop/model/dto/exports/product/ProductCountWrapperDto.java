package bg.softuni.productshop.model.dto.exports.product;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sold-products")
public class ProductCountWrapperDto {

    @XmlAttribute(name = "count")
    private Integer count;
    @XmlElement(name = "product")
    private List<ProductNameAndPriceDto> products;

    public ProductCountWrapperDto() {
    }

    public ProductCountWrapperDto(List<ProductNameAndPriceDto> products) {
        this.products = products;
        this.count = products.size();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductNameAndPriceDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNameAndPriceDto> products) {
        this.products = products;
    }


}
