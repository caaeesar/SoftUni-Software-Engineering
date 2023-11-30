package bg.softuni.productsshop.model.dto.productDtos;

import java.util.List;

public class ProductCountWrapperDto {

    private int count;
    private List<ProductNameAndPriceDto> products;

    public ProductCountWrapperDto(List<ProductNameAndPriceDto> products) {
        this.products = products;
        this.count = products.size();
    }
}
