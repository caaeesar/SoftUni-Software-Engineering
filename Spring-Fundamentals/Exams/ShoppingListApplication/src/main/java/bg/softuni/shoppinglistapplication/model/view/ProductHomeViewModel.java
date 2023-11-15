package bg.softuni.shoppinglistapplication.model.view;


import java.math.BigDecimal;
import java.util.List;

public class ProductHomeViewModel {

   private List<ProductsFoodViewModel> productsFood;

   private List<ProductsDrinkViewModel> productsDrink;

   private List<ProductsHouseholdViewModel> productsHousehold;

   private List<ProductOtherViewModel> productOther;

   private BigDecimal totalPrice;

    public ProductHomeViewModel(List<ProductsFoodViewModel> productsFood, List<ProductsDrinkViewModel> productsDrink, List<ProductsHouseholdViewModel> productsHousehold, List<ProductOtherViewModel> productOther, BigDecimal totalPrice) {
        this.productsFood = productsFood;
        this.productsDrink = productsDrink;
        this.productsHousehold = productsHousehold;
        this.productOther = productOther;
        this.totalPrice = totalPrice;
    }

    public ProductHomeViewModel() {

    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductsFoodViewModel> getProductsFood() {
        return productsFood;
    }

    public void setProductsFood(List<ProductsFoodViewModel> productsFood) {
        this.productsFood = productsFood;
    }

    public List<ProductsDrinkViewModel> getProductsDrink() {
        return productsDrink;
    }

    public void setProductsDrink(List<ProductsDrinkViewModel> productsDrink) {
        this.productsDrink = productsDrink;
    }

    public List<ProductsHouseholdViewModel> getProductsHousehold() {
        return productsHousehold;
    }

    public void setProductsHousehold(List<ProductsHouseholdViewModel> productsHousehold) {
        this.productsHousehold = productsHousehold;
    }

    public List<ProductOtherViewModel> getProductOther() {
        return productOther;
    }

    public void setProductOther(List<ProductOtherViewModel> productOther) {
        this.productOther = productOther;
    }
}
