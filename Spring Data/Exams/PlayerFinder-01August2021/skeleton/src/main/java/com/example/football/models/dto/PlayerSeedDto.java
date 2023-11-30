package com.example.football.models.dto;

import com.example.football.models.entity.enums.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "player")
public class PlayerSeedDto {

    @XmlElement(name = "first-name")
    @NotNull
    @Size(min = 3)
    private String firstName;

    @XmlElement(name = "last-name")
    @NotNull
    @Size(min = 3)
    private String lastName;

    @XmlElement
    @NotNull
    @Email
    private String email;

    @XmlElement(name = "birth-date")
    @NotNull
    private String birthDate;

    @XmlElement
    @NotNull
    private Position position;

    @XmlElement
    private TownWithNameDto town;

    @XmlElement
    private TeamWithNameDto team;

    @XmlElement
    private StatWithIdDto stat;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TownWithNameDto getTown() {
        return town;
    }

    public void setTown(TownWithNameDto town) {
        this.town = town;
    }

    public TeamWithNameDto getTeam() {
        return team;
    }

    public void setTeam(TeamWithNameDto team) {
        this.team = team;
    }

    public StatWithIdDto getStat() {
        return stat;
    }

    public void setStat(StatWithIdDto stat) {
        this.stat = stat;
    }
}
