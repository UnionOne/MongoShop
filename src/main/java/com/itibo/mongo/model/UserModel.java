package com.itibo.mongo.model;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class UserModel {
    private String sku;
    private String type;
    private String title;
    private String publisher;
    private String artist;
    private String author;

    public UserModel(String sku, String type, String title, String publisher, String artist, String author) {
        this.sku = sku;
        this.type = type;
        this.title = title;
        this.publisher = publisher;
        this.artist = artist;
        this.author = author;
    }

    public UserModel() {
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
