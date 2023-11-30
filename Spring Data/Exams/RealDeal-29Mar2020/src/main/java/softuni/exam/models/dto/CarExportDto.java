package softuni.exam.models.dto;

import softuni.exam.models.entity.Picture;

import java.time.LocalDate;
import java.util.List;

public class CarExportDto {

    private String make;

    private String model;

    private Integer kilometers;

    private LocalDate registeredOn;

    private List<PictureExportDto> pictures;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public List<PictureExportDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureExportDto> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        String format = "Car make - %s, model - %s\n" +
                "\tKilometers - %d\n" +
                "\tRegistered on - %s\n" +
                "\tNumber of pictures - %d";
        return String.format(format, getMake(), getModel(), getKilometers(), getRegisteredOn(), getPictures().size());
    }
}
