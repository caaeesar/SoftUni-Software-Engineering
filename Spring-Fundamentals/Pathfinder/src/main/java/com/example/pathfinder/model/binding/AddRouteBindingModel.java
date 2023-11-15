package com.example.pathfinder.model.binding;

import com.example.pathfinder.model.entity.enums.CategoryType;
import com.example.pathfinder.model.entity.enums.RouteLevel;

import java.util.Set;

public class AddRouteBindingModel {

    private String name;

    private String description;

    private RouteLevel level;

    private String videoUrl;

    private Set<CategoryType> categories;

    public Set<CategoryType> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryType> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RouteLevel getLevel() {
        return level;
    }

    public void setLevel(RouteLevel level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
