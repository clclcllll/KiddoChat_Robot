package com.example.educationalrobot1.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IFlyTekApiUtils {

    public static String sendGetRequest(String apiUrl, String apiKey, String apiSecret) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("apiKey", apiKey);
        conn.setRequestProperty("apiSecret", apiSecret);

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }

    public static String sendPostRequest(String apiUrl, String apiKey, String apiSecret, String payload) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("apiKey", apiKey);
        conn.setRequestProperty("apiSecret", apiSecret);
        conn.setDoOutput(true);

        conn.getOutputStream().write(payload.getBytes());

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }
}
