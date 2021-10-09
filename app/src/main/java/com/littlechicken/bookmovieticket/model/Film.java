package com.littlechicken.bookmovieticket.model;

public class Film {
    int img;
    String name;

    public Film() {
    }

    public Film(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
