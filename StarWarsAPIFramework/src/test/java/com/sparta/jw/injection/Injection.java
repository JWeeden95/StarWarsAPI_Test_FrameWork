package com.sparta.jw.injection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.jw.connection.ConnectionManager;
import com.sparta.jw.dtos.DTO;
import java.io.IOException;
import java.net.http.HttpResponse;

public class Injection {
    private static String BASE_URL = "https://swapi.dev/api/";

    public static DTO inject(String endPoint) {

        if (endPoint.matches("https://swapi.dev/api/.*")) {
            endPoint = endPoint.replaceAll("https://swapi.dev/api/", "");
        }
        if (endPoint.matches("http://swapi.dev/api/.*")){
            endPoint = endPoint.replaceAll("http://swapi.dev/api/", "");
        }
            DTO dto = DTOFactory.createDTO(endPoint);
            ObjectMapper objectMapper = new ObjectMapper();
            StringBuilder url = new StringBuilder();
            url.append(BASE_URL).append(endPoint);

            try {
                HttpResponse<String> httpResponse = ConnectionManager.getConnectionResponse(url.toString());
                assert dto != null;
                dto = objectMapper.readValue(httpResponse.body(), dto.getClass());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return dto;
    }
}
