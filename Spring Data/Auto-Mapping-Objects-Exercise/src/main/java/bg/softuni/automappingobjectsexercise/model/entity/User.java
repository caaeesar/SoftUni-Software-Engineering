package bg.softuni.automappingobjectsexercise.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Game> games;
    private boolean isAdmin;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Order> orders;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Game> shoppingCard;

    public List<Game> getShoppingCard() {
        return shoppingCard;
    }

    public void setShoppingCard(List<Game> shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

    public User() {
        this.orders = new HashSet<>();
        this.games = new HashSet<>();
        this.shoppingCard = new ArrayList<>();
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isHasGame(Game game) {
        for (Game current : this.games) {
            if (current.getTitle().equals(game.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public boolean isHasGameInShoppingCard(Game game) {
        for (Game current : this.shoppingCard) {
            if (current.getTitle().equals(game.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public boolean removeGameFromCard(Game game) {
        for (int i = 0; i < this.shoppingCard.size(); i++) {
            if (this.shoppingCard.get(i).getTitle().equals(game.getTitle())) {
                this.shoppingCard.remove(i);
                return true;
            }
        }
        return false;
    }
}
