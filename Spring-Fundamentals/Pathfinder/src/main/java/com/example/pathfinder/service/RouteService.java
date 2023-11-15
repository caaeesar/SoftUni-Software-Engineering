package com.example.pathfinder.service;

import com.example.pathfinder.model.binding.AddRouteBindingModel;
import com.example.pathfinder.model.entity.RouteEntity;

import java.util.List;

public interface RouteService {

    void addRoute(AddRouteBindingModel addRouteBindingModel);

    List<RouteEntity> findAllRoutes();

    RouteEntity findRouteById(Long id);

}
