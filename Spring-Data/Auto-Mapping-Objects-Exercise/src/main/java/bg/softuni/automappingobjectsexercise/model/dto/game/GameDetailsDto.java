package bg.softuni.automappingobjectsexercise.model.dto.game;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDetailsDto {

    private String title;
    private BigDecimal price;
    private double size;
    private String trailer;
    private String imageThumbnail;
    private String description;
    private LocalDate releaseDate;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("Title: %s", this.title)).append(System.lineSeparator());
        out.append(String.format("Price: %s", this.price)).append(System.lineSeparator());
        out.append(String.format("Description: %s", this.description)).append(System.lineSeparator());
        out.append(String.format("Release date: %s", this.releaseDate)).append(System.lineSeparator());
        return out.toString();
    }
}
