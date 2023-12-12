package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID;
    @Column(name = "username")
    private int username;
    @Column(name = "password")
    private int password;
    @Column(name = "phone_number")
    private int phone_number;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "favorite",
            joinColumns = @JoinColumn(name = "userID", referencedColumnName = "userID"),
            inverseJoinColumns = @JoinColumn(name = "movieID", referencedColumnName = "movieID")
    )
    private List<Movie> favorites;

    public User() {
    }

    public User(int userID, int username, int password, int phone_number, List<Movie> favorites) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.favorites = favorites;
    }
}
