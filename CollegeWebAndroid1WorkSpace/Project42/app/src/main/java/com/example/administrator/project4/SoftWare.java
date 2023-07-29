package com.example.administrator.project4;

import java.io.Serializable;

public class SoftWare implements Serializable {
    private String artistName;
    private Double price;
    private String[] supportedDevices;
    private String description;
    private String[] genres;
    private String[] screenshotUrls;

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSupportedDevices(String[] supportedDevices) {
        this.supportedDevices = supportedDevices;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public void setScreenshotUrls(String[] screenshotUrls) {
        this.screenshotUrls = screenshotUrls;
    }

    public String[] getScreenshotUrls() {
        return screenshotUrls;
    }

    public String getArtistName() {
        return artistName;
    }

    public Double getPrice() {
        return price;
    }

    public String[] getSupportedDevices() {
        return supportedDevices;
    }

    public String getDescription() {
        return description;
    }

    public String[] getGenres() {
        return genres;
    }


    public SoftWare(String artistName, Double price, String[] supportedDevices, String description, String[] genres, String[] screenshotUrls) {
        this.artistName = artistName;
        this.price = price;
        this.supportedDevices = supportedDevices;
        this.description = description;
        this.genres = genres;
        this.screenshotUrls = screenshotUrls;
    }
}
