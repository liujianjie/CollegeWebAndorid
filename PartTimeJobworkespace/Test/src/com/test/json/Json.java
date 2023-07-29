package com.test.json;

import org.json.JSONException;
import org.json.JSONObject;

public class Json {
    public static Music Json(String searchResult) {
        Music music = null;
        try {
            JSONObject jsonObject = new JSONObject(searchResult.substring(searchResult.indexOf("{"), searchResult.lastIndexOf("}") + 1));
            String trackName = jsonObject.optString("trackName");
            String artistName = jsonObject.optString("artistName");
            Double trackPrice =  jsonObject.optDouble("trackPrice");
            Double collectionPrice =  jsonObject.optDouble("collectionPrice");
            String collectionName = jsonObject.optString("collectionName");
            String artworkUrl30 = jsonObject.optString("artworkUrl30");

            music = new Music(trackName,artistName,trackPrice,collectionPrice,collectionName,artworkUrl30);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return music;
    }
}
