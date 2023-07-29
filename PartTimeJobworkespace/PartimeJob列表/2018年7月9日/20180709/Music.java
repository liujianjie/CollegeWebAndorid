package com.example.administrator.project4;

public class Music {
    private String trackName;
    private String artistName;
    private Double trackPrice;
    private Double collectionPrice;
    private String collectionName;
    private String artworkUrl30;
    public Music(String trackName, String artistName, Double trackPrice, Double collectionPrice, String collectionName, String artworkUrl30) {
        this.trackName=trackName;
        this.artistName=artistName;
        this.trackPrice=trackPrice;
        this.collectionName=collectionName;
        this.collectionPrice=collectionPrice;
        this.artworkUrl30=artworkUrl30;
    }
    public String getTrackName(){
        return this.trackName;
    }
    public String getArtistName(){
        return this.artistName;
    }
    public String getCollectionName(){
        return this.collectionName;
    }
    public String getArtworkUrl30(){
        return this.artworkUrl30;
    }
    public Double getTrackPrice(){
        return this.trackPrice;
    }
    public Double getCollectionPrice(){
        return this.collectionPrice;
    }

}
