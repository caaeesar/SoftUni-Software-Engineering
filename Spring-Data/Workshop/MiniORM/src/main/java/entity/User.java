package entity;

import lombok.Getter;
import lombok.Setter;
import orm.annotation.Column;
import orm.annotation.Entity;
import orm.annotation.Id;

import java.time.LocalDate;

@Entity(tableName = "users")
@Setter
@Getter
public class User { // POJO

    @Id
    private long id;

    @Column(name = "username", columnDefinition = "VARCHAR(70)")
    private String username;

    @Column(name = "age", columnDefinition = "INT")
    private  int age;

    @Column(name = "registration_date", columnDefinition = "DATE")
    private LocalDate registration;

    public User(String username, int age, LocalDate registration) {
        this.username = username;
        this.age = age;
        this.registration = registration;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }
}
