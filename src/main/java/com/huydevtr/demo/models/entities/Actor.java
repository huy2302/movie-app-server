package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actorID")
    private int ActorID;
    @Column(name = "actorName")
    private String ActorName; // tên diễn viên
    @Column(name = "age")
    private String Age; // tuổi
    @Column(name = "country")
    private String Country; // quốc tịch
    @Column(name = "gender")
    private String Gender; // giới tính
    @Column(name = "avt")
    private String Avt; // link avt
    @ManyToMany(mappedBy = "actorList", fetch = FetchType.LAZY)
    private List<Movie> movieList;
    @Column(name = "description")
    private String Description; // mô tả

    public Actor() {
    }

    public Actor(int actorID, String actorName, String age, String country, String gender, String avt, String description) {
        ActorID = actorID;
        ActorName = actorName;
        Age = age;
        Country = country;
        Gender = gender;
        Avt = avt;
        Description = description;
    }
}
