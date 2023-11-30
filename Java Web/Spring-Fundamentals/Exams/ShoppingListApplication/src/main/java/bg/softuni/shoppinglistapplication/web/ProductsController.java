package bg.softuni.shoppinglistapplication.web;

import bg.softuni.shoppinglistapplication.model.binding.ProductAddBindingModel;
import bg.softuni.shoppinglistapplication.model.entity.enums.CategoryName;
import bg.softuni.shoppinglistapplication.model.service.ProductServiceModel;
import bg.softuni.shoppinglistapplication.service.ProductService;
import bg.softuni.shoppinglistapplication.session.LoggedUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

   private final ProductService productService;

    @Autowired
    public ProductsController(LoggedUser loggedUser, ModelMapper modelMapper, ProductService productService) {
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }

    @ModelAttribute
    public void addCategoriesToModel(Model model) {
        model.addAttribute("categories", CategoryName.values());
    }

    @GetMapping("/add")
    String addProduct() {
        if (loggedUser.isLogged()) {
            return "product-add";
        }
        return "redirect:/";
    }

    @PostMapping("/add")
    String addProductConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";
        }

        ProductServiceModel productServiceModel = modelMapper.map(productAddBindingModel, ProductServiceModel.class);
        boolean isCreated = productService.createProduct(productServiceModel);
        if (!isCreated) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            return "redirect:add";
        }

        return "redirect:/";
    }

    @DeleteMapping("/buy/{id}")
    public String buy(@PathVariable String id) {
        productService.buyProduct(id);
        return "redirect:/";
    }


    @DeleteMapping("/buyAll")
    public String buyAll() {
        productService.buyAllProducts();
        return "redirect:/";
    }

}
