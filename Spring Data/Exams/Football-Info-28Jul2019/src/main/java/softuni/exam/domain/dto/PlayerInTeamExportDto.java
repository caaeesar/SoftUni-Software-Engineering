package softuni.exam.domain.dto;

import softuni.exam.domain.entities.enums.Position;

public class PlayerInTeamExportDto {

    private String firstName;
    private String lastName;
    private Integer number;
    private Position position;

    private String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        String format = "Team: %s\n" +
                "Player name: %s %s - %s\n" +
                "Number: %d";
        return String.format(format, getTeamName(), getFirstName(),getLastName(),getPosition(),getNumber());
    }
}
