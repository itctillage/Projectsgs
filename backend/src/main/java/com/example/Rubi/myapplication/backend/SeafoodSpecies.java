package com.example.Rubi.myapplication.backend;

import com.googlecode.objectify.annotation.Id;

/**
 * Created by Rubi on 30/03/2015.
 */
public class SeafoodSpecies {
    @Id
    Long id;
    String name;
    String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}