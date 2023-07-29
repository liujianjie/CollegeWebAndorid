package com.example.administrator.project4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HpptRequest {
    public static String HpptRequest(String item, String option) {
        String url = "https://itunes.apple.com/search?";
        String url2="term="+item;
        String url3="&entity="+option;
        String CurrentURL=url+url2+url3;

        return httpRequest(CurrentURL);
    }
    public static String httpRequest(String URL) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();


        try {
            URL url = new URL(URL);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();

            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));//UTF-8
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
