package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.binding.AddRouteBindingModel;
import com.example.pathfinder.model.entity.CategoryEntity;
import com.example.pathfinder.model.entity.RouteEntity;
import com.example.pathfinder.repository.CategoryRepository;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserService userService;

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, UserService userService, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addRoute(AddRouteBindingModel addRouteBindingModel) {

     /*   TypeMap<AddRouteBindingModel, RouteEntity> typeMap = modelMapper.createTypeMap(AddRouteBindingModel.class, RouteEntity.class);
        typeMap.addMappings(mapper -> {
            mapper.skip(RouteEntity::setCategories);
        });*/

        RouteEntity route = modelMapper.map(addRouteBindingModel, RouteEntity.class);

        Set<CategoryEntity> categories = categoryRepository.getByNameIn(addRouteBindingModel.getCategories());
        route.setCategories(categories);

        route.setAuthor(userService.getLoggedUser());

        routeRepository.save(route);
    }

    @Override
    public List<RouteEntity> findAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public RouteEntity findRouteById(Long id) {
        return routeRepository.findById(id).get();
    }
}
