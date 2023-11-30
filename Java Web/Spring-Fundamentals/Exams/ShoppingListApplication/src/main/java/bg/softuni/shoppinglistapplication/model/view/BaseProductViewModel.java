package bg.softuni.shoppinglistapplication.model.view;

import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;

import java.math.BigDecimal;

public class BaseProductViewModel {

    private String id;
    private String name;

    private BigDecimal price;

    private CategoryName category;

    public BaseProductViewModel(String id, String name, BigDecimal price, CategoryName category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public BaseProductViewModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }
}
