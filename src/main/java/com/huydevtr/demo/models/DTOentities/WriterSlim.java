package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WriterSlim {
    @JsonProperty("WriterName")
    private String WriterName;
    @JsonProperty("avt")
    private String avt;

    public WriterSlim() {
    }
    public WriterSlim(String actorName, String avt) {
        WriterName = actorName;
        this.avt = avt;
    }
}
