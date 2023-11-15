package bg.softuni.shoppinglistapplication.web;

import bg.softuni.shoppinglistapplication.model.entity.Product;
import bg.softuni.shoppinglistapplication.model.view.ProductHomeViewModel;
import bg.softuni.shoppinglistapplication.service.ProductService;
import bg.softuni.shoppinglistapplication.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final ProductService productService;

    @Autowired
    public HomeController(LoggedUser loggedUser, ProductService productService) {
        this.loggedUser = loggedUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (loggedUser.isLogged()) {
            ProductHomeViewModel productHomeViewModel = productService.findAllProductForHomePage();
            model.addAttribute("allProducts", productHomeViewModel);
            return "home";
        }
        return "index";
    }
}
