package bg.softuni.coffeeshopapplication.web;

import bg.softuni.coffeeshopapplication.model.view.OrderViewModel;
import bg.softuni.coffeeshopapplication.service.OrderService;
import bg.softuni.coffeeshopapplication.service.UserService;
import bg.softuni.coffeeshopapplication.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public HomeController(LoggedUser loggedUser, OrderService orderService, UserService userService) {
        this.loggedUser = loggedUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (!loggedUser.isLogged()) {
            return "index";
        }

        List<OrderViewModel> orders = orderService.findAllOrders();
        Integer totalTime = orders.stream().map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum).orElse(0);

        model.addAttribute("orders", orders);
        model.addAttribute("totalTime", totalTime);
        model.addAttribute("employees", userService.findAllEmployees());
        return "home";
    }

}
