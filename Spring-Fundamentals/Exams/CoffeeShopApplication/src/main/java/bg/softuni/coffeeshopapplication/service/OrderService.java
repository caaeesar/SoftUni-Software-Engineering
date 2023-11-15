package bg.softuni.coffeeshopapplication.service;

import bg.softuni.coffeeshopapplication.model.binding.OrderAddBindingModel;
import bg.softuni.coffeeshopapplication.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    void addOrder(OrderAddBindingModel orderAddBindingModel);

    List<OrderViewModel> findAllOrders();

    void readyOrder(Long id);
}
