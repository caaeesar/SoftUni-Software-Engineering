package bg.softuni.automappingobjectsexercise.model.dto.game;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class GameAddDto {

    @Pattern(regexp = "^[A-Z].{3,100}", message = "Invalid title format.")
    private String title;
    @DecimalMin(value = "0", message = "Price must be a positive number.")
    private BigDecimal price;
    @Positive(message = "Size must be a positive number.")
    private double size;
    @Length(min = 11, max = 11, message = "Invalid trailer length.")
    private String trailer;
    @Pattern(regexp = "(https?:\\/\\/).*", message = "Invalid URL.")
    private String thumbnailURL;
    @Length(min = 20, message = "Too short description.")
    private String description;
    private String releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, double size, String trailer, String thumbnailURL, String description, String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
    }

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

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
