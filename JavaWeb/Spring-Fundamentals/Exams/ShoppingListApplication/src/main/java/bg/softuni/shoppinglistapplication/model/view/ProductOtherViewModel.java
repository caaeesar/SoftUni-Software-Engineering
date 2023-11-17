package bg.softuni.shoppinglistapplication.model.view;

import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;

import java.math.BigDecimal;

public class ProductOtherViewModel extends BaseProductViewModel {

    public ProductOtherViewModel(String id, String name, BigDecimal price, CategoryName category) {
        super(id, name, price, category);
    }

    public ProductOtherViewModel() {
        super();
    }
}
