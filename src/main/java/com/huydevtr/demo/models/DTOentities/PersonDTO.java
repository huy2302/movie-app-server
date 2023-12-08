package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonDTO {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private String age;
    @JsonProperty("country")
    private String country;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("avt")
    private String avt;
    @JsonProperty("description")
    private String description;

    public PersonDTO() {
    }

    public PersonDTO(int id, String name, String age, String country, String gender, String avt, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.gender = gender;
        this.avt = avt;
        this.description = description;
    }
}
