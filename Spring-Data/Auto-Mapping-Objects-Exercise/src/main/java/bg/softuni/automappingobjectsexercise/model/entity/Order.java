package bg.softuni.automappingobjectsexercise.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Game> games;

    public Order(User user) {
        this.user = user;
        this.games = new ArrayList<>();
    }

    public Order() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
