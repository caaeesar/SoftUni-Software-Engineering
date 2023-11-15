package bg.softuni.coffeeshopapplication.model.view;

import bg.softuni.coffeeshopapplication.model.entity.Order;

import java.util.List;

public class UserViewModel {

    private String firstName;
    private List<OrderViewModel> orders;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<OrderViewModel> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderViewModel> orders) {
        this.orders = orders;
    }
}
