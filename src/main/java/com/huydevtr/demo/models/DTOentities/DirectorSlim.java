package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DirectorSlim {
    @JsonProperty("DirectorName")
    private String DirectorName;
    @JsonProperty("avt")
    private String avt;

    public DirectorSlim() {
    }
    public DirectorSlim(String actorName, String avt) {
        DirectorName = actorName;
        this.avt = avt;
    }
}
