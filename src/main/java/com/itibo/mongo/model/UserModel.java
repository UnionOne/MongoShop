package com.itibo.mongo.model;

/**
 * Created by union on 15.02.2016.
 */

public class UserModel {
    private int sku;
    private String type;
    private String title;
    private String publisher;
    private String artist;
    private String author;

    public UserModel(int sku, String type, String title, String publisher, String artist, String author) {
        this.sku = sku;
        this.type = type;
        this.title = title;
        this.publisher = publisher;
        this.artist = artist;
        this.author = author;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
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

    @Override
    public String toString() {
        return "UserModel{" +
                "sku=" + sku +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", artist='" + artist + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
