package com.example.cnkua.discoverethiopia.Models;

/**
 * Created by CNKU A on 5/20/2018.
 */

public class Agent {
    private String Name;
    private int Info;
    private int image;

    public Agent(String name, int info, int image) {
        Name = name;
        Info = info;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getInfo() {
        return Info;
    }

    public void setInfo(int info) {
        Info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
