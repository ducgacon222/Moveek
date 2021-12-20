package com.littlechicken.bookmovieticket.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * on 07,December,2021
 */
public class Data {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("posterImage")
    @Expose
    private String posterImage;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("ticketCost")
    @Expose
    private String ticketCost;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("writers")
    @Expose
    private String writers;
    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("filmTypeID")
    @Expose
    private String filmTypeID;
    @SerializedName("cinemaID")
    @Expose
    private String cinemaID;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @Expose
    private String Date;
    @Expose
    private String Today;
    @Expose
    private String seate;

    @Expose
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeate() {
        return seate;
    }

    public void setSeate(String seate) {
        this.seate = seate;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getToday() {
        return Today;
    }

    public void setToday(String today) {
        Today = today;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(String ticketCost) {
        this.ticketCost = ticketCost;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriters() {
        return writers;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFilmTypeID() {
        return filmTypeID;
    }

    public void setFilmTypeID(String filmTypeID) {
        this.filmTypeID = filmTypeID;
    }

    public String getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(String cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
