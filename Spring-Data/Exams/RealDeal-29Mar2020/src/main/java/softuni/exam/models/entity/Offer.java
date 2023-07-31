package softuni.exam.models.entity;


import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "has_gold_status")
    private Boolean hasGoldStatus;

    @Column(name = "added_on")
    private LocalDateTime addedOn;

    @ManyToMany
    @JoinTable(
            name = "offers_pictures",
            joinColumns = @JoinColumn(name = "picture_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id")
    )
    private List<Picture> pictures;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
