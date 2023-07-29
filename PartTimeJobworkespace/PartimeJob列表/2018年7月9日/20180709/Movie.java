package com.example.administrator.project4;

public class Movie {
    private String trackName;
    private String longDescription;
    private String contentAdvisoryRating;
    private Double trackHdPrice;
    private String primaryGenreName;
    private String artworkUrl30;
    public Movie(String trackName, String longDescription, String contentAdvisoryRating, Double trackHdPrice, String primaryGenreName, String artworkUrl30) {
        this.trackName=trackName;
        this.trackHdPrice=trackHdPrice;
        this.longDescription=longDescription;
        this.contentAdvisoryRating=contentAdvisoryRating;
        this.artworkUrl30=artworkUrl30;
        this.primaryGenreName=primaryGenreName;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public Double getTrackHdPrice() {
        return trackHdPrice;
    }

    public String getTrackName() {
        return trackName;
    }
}
