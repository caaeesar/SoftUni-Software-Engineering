package com.example.pathfinder.web;


import com.example.pathfinder.model.binding.AddRouteBindingModel;
import com.example.pathfinder.model.entity.RouteEntity;
import com.example.pathfinder.model.entity.enums.CategoryType;
import com.example.pathfinder.model.entity.enums.RouteLevel;
import com.example.pathfinder.model.view.RouteDetailViewModel;
import com.example.pathfinder.model.view.RouteViewModel;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/routes")
public class RoutesController {

    private final RouteService routeService;
    private final ModelMapper modelMapper;

    @Autowired
    public RoutesController(RouteService routeService, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public void addDataToModel(Model model) {
        model.addAttribute("levels", RouteLevel.values());
        model.addAttribute("categories", CategoryType.values());
    }

    @GetMapping("/add")
    public String addRoute(){
        return "add-route";
    }

    @PostMapping("/add")
    public String addRoute(AddRouteBindingModel addRouteBindingModel){
        routeService.addRoute(addRouteBindingModel);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {
        List<RouteViewModel> routeViewModels = routeService.findAllRoutes().stream().map(r -> modelMapper.map(r, RouteViewModel.class)).toList();
        model.addAttribute("routes", routeViewModels);
        return "routes";
    }

    @GetMapping("/details/{id}")
    public String detailsRoute(@PathVariable Long id, Model model) {
        RouteEntity routeEntity = routeService.findRouteById(id);
        RouteDetailViewModel routeDetailViewModel = modelMapper.map(routeEntity,RouteDetailViewModel.class);
        routeDetailViewModel.setAuthor(routeEntity.getAuthor());
        model.addAttribute("route", routeDetailViewModel);
        return "route-details";
    }

}
