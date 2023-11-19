package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directorID")
    private int DirectorID;
    @Column(name = "directorName")
    private String DirectorName; // tên đạo diễn
    @Column(name = "age")
    private String Age; // tuổi
    @Column(name = "country")
    private String Country; // quốc tịch
    @Column(name = "gender")
    private String Gender; // giới tính
    @Column(name = "avt")
    private String Avt; // link avt
    @Column(name = "description")
    private String Description; // mô tả

    public Director() {
    }

    public Director(int directorID, String directorName, String age, String country, String gender, String avt, String description) {
        DirectorID = directorID;
        DirectorName = directorName;
        Age = age;
        Country = country;
        Gender = gender;
        Avt = avt;
        Description = description;
    }
}
