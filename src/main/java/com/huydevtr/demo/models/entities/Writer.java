package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "writer")
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "writerID")
    private int WriterID;
    @Column(name = "writerName")
    private String WriterName; // tên diễn viên
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

    public Writer() {
    }

    public Writer(int actorID, String actorName, String age, String country, String gender, String avt, String description) {
        WriterID = actorID;
        WriterName = actorName;
        Age = age;
        Country = country;
        Gender = gender;
        Avt = avt;
        Description = description;
    }
}
