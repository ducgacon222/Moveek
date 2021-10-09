package com.littlechicken.bookmovieticket.model;

public class Blog {
    int img;
    String title;

    public Blog() {
    }

    public Blog(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
