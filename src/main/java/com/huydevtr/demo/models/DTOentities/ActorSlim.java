package com.huydevtr.demo.models.DTOentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ActorSlim {
    @JsonProperty("ActorName")
    private String ActorName;
    @JsonProperty("avt")
    private String avt;

    public ActorSlim() {
    }
    public ActorSlim(String actorName, String avt) {
        ActorName = actorName;
        this.avt = avt;
    }
}
