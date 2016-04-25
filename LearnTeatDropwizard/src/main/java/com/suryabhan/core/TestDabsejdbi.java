package com.suryabhan.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by suryabhan on 26/04/16.
 */
public class TestDabsejdbi {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
