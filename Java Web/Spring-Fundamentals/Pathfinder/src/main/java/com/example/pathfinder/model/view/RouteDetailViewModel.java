package com.example.pathfinder.model.view;

import com.example.pathfinder.model.entity.UserEntity;
import com.example.pathfinder.model.entity.enums.RouteLevel;

public class RouteDetailViewModel {

    private String name;
    private UserEntity author;
    private String description;
    private String videoUrl;
    private RouteLevel level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public RouteLevel getLevel() {
        return level;
    }

    public void setLevel(RouteLevel level) {
        this.level = level;
    }
}
