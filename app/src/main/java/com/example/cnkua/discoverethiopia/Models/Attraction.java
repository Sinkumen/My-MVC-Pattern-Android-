package com.example.cnkua.discoverethiopia.Models;

/**
 * Created by CNKU A on 5/16/2018.
 */

public class Attraction {
    private String Name;
    private String Quote;
    private String Description;
    private int thumbnail;
    private int info;



    public Attraction() {

    }

    public Attraction(String name,String quote,int info, String description,int thumbnail) {
        Name = name;
        Description = description;
        this.thumbnail = thumbnail;
        this.Quote=quote;
        this.info=info;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
    public int getInfo() {return info;}

    public void setInfo(int info) {this.info = info; }
    public String getQuote() {return Quote;}

    public void setQuote(String quote) {Quote = quote;}
}

