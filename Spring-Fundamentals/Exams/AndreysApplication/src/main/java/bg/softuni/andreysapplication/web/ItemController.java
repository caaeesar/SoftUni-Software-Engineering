package bg.softuni.andreysapplication.web;

import bg.softuni.andreysapplication.model.binding.ItemAddBindingModel;
import bg.softuni.andreysapplication.model.entity.enums.CategoryName;
import bg.softuni.andreysapplication.model.entity.enums.Gender;
import bg.softuni.andreysapplication.model.service.ItemServiceModel;
import bg.softuni.andreysapplication.service.ItemService;
import bg.softuni.andreysapplication.session.SessionUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final SessionUser sessionUser;
    private final ModelMapper modelMapper;
    private final ItemService itemService;

    @Autowired
    public ItemController(SessionUser sessionUser, ModelMapper modelMapper, ItemService itemService) {
        this.sessionUser = sessionUser;
        this.modelMapper = modelMapper;
        this.itemService = itemService;
    }

    @ModelAttribute
    public ItemAddBindingModel itemAddBindingModel() {
        return new ItemAddBindingModel();
    }

    @ModelAttribute
    public void populateData(Model model) {
        model.addAttribute("categories", CategoryName.values())
                .addAttribute("genders", Gender.values());
    }

    @GetMapping("/add")
    public String addItem() {
        if (sessionUser.isLogged()) {
            return "add-item";
        }
        return "redirect:/";
    }


    @PostMapping("/add")
    public String addItemRequest(@Valid ItemAddBindingModel itemAddBindingModel,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:add";
        }

        ItemServiceModel itemServiceModel = modelMapper.map(itemAddBindingModel, ItemServiceModel.class);
        boolean canCreate = itemService.createItem(itemServiceModel);
        if (!canCreate) {
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            return "redirect:add";
        }

        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String itemDetails(@PathVariable String id, Model model){
        model.addAttribute("itemDetailsViewModel", itemService.findItemDetailsById(id));
        return "details-item";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable String id) {
        itemService.deleteItemById(id);
        return "redirect:/";
    }

}
