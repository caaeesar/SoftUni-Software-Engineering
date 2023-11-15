package bg.softuni.coffeeshopapplication.service.impl;

import bg.softuni.coffeeshopapplication.model.binding.OrderAddBindingModel;
import bg.softuni.coffeeshopapplication.model.entity.Order;
import bg.softuni.coffeeshopapplication.model.view.OrderViewModel;
import bg.softuni.coffeeshopapplication.repository.CategoryRepository;
import bg.softuni.coffeeshopapplication.repository.OrderRepository;
import bg.softuni.coffeeshopapplication.repository.UserRepository;
import bg.softuni.coffeeshopapplication.service.OrderService;
import bg.softuni.coffeeshopapplication.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, CategoryRepository categoryRepository, LoggedUser loggedUser, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addOrder(OrderAddBindingModel orderAddBindingModel) {
        Order order = modelMapper.map(orderAddBindingModel, Order.class);
        order.setEmployee(userRepository.findById(loggedUser.getId()).get());
        order.setCategory(categoryRepository.getByName(orderAddBindingModel.getCategory()));
        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrders() {
        return orderRepository.findOrdersByOrderByPrice()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
