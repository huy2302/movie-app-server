package com.huydevtr.demo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "production")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productionID")
    private int ProductionID;
    @Column(name = "production")
    private String Production; // tên studio sản xuất
    @Column(name = "year")
    private String Year; // năm ra mắt
    @Column(name = "country")
    private String Country; // quốc gia
    @Column(name = "description")
    private String Description; // mô tả

    public Production() {
    }

    public Production(int productionID, String production, String year, String country, String description) {
        ProductionID = productionID;
        Production = production;
        Year = year;
        Country = country;
        Description = description;
    }
}
