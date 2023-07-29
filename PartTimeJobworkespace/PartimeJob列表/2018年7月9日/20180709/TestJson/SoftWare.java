package com.example.administrator.project4;

public class SoftWare {
    private String artistName;
    private Double price;
    private String supportedDevices;
    private String description;
    private String genres;
    private String screenshotUrls;
    private String ipadScreenshotUrls;

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSupportedDevices(String supportedDevices) {
        this.supportedDevices = supportedDevices;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setScreenshotUrls(String screenshotUrls) {
        this.screenshotUrls = screenshotUrls;
    }

    public void setIpadScreenshotUrls(String ipadScreenshotUrls) {
        this.ipadScreenshotUrls = ipadScreenshotUrls;
    }

    public String getArtistName() {
        return artistName;
    }

    public Double getPrice() {
        return price;
    }

    public String getSupportedDevices() {
        return supportedDevices;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres() {
        return genres;
    }

    public String getScreenshotUrls() {
        return screenshotUrls;
    }

    public String getIpadScreenshotUrls() {
        return ipadScreenshotUrls;
    }

    public SoftWare(String artistName, Double price, String supportedDevices, String description, String genres, String screenshotUrls, String ipadScreenshotUrls) {
        this.artistName = artistName;
        this.price = price;
        this.supportedDevices = supportedDevices;
        this.description = description;
        this.genres = genres;
        this.screenshotUrls = screenshotUrls;
        this.ipadScreenshotUrls = ipadScreenshotUrls;
    }
    public SoftWare(String artistName, Double price){
        this.artistName = artistName;
        this.price = price;
    }
}
