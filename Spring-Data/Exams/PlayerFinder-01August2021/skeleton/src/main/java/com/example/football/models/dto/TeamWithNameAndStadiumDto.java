package com.example.football.models.dto;

public class TeamWithNameAndStadiumDto {

    private String name;
    private String stadiumName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }
}
