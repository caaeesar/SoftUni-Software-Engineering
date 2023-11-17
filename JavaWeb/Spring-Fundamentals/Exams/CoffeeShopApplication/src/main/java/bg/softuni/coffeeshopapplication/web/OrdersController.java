package bg.softuni.coffeeshopapplication.web;

import bg.softuni.coffeeshopapplication.model.binding.OrderAddBindingModel;
import bg.softuni.coffeeshopapplication.model.entity.enums.CategoryType;
import bg.softuni.coffeeshopapplication.service.OrderService;
import bg.softuni.coffeeshopapplication.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;
    private final LoggedUser loggedUser;

    @Autowired
    public OrdersController(OrderService orderService, LoggedUser loggedUser) {
        this.orderService = orderService;
        this.loggedUser = loggedUser;
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }

    @ModelAttribute
    public void addCategoriesToModel(Model model) {
        model.addAttribute("categories", CategoryType.values());
    }

    @GetMapping("/add")
    public String addOrder() {
        if (loggedUser.isLogged()){
        return "order-add";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    public String addOrder(@Valid OrderAddBindingModel orderAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("orderAddBindingModel", orderAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);
           // return "redirect:/orders/add";
            return "redirect:add";
        }

        orderService.addOrder(orderAddBindingModel);
        return "redirect:/";
    }

    @DeleteMapping("/ready/{id}")
    public String readyOrder(@PathVariable Long id) {
        orderService.readyOrder(id);
        return "redirect:/";
    }

}
