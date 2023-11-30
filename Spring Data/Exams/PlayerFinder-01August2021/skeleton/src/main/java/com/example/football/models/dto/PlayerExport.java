package com.example.football.models.dto;

import com.example.football.models.entity.enums.Position;

public class PlayerExport {

    private String firstName;
    private String lastName;
    private Position position;
    private TeamWithNameAndStadiumDto team;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TeamWithNameAndStadiumDto getTeam() {
        return team;
    }

    public void setTeam(TeamWithNameAndStadiumDto team) {
        this.team = team;
    }

    @Override
    public String toString() {
        String format = "Player - %s %s\n    Position - %s\n    Team - %s\n    Stadium - %s";
        return String.format(format, getFirstName(), getLastName(), getPosition().name(), getTeam().getName(), getTeam().getStadiumName());
    }
}
