package com.sparta.jw.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {

    public static HttpResponse getConnectionResponse(String URL) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = null;
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public static int getStatusCode(HttpResponse<String> httpResponse){
        return httpResponse.statusCode();
    }

    public static boolean connectionIsOkay(HttpResponse httpResponse){
        if (httpResponse.statusCode() == 200){
            return true;
        }
        return false;
    }
}
