package com.sparta.jw;

import com.sparta.jw.connection.ConnectionManager;
import com.sparta.jw.dtos.*;
import com.sparta.jw.injection.Injection;
import com.sparta.jw.shortcuts.BodyTest;
import com.sparta.jw.shortcuts.ConnectionTest;
import com.sparta.jw.shortcuts.HeadersTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.net.http.HttpResponse;

public class Tests {

    private static HttpResponse<String> httpResponse;
    private static FilmsDTO dtoFilm;
    private static PeopleDTO dtoPeople;
    private static PlanetsDTO dtoPlanet;
    private static SpeciesDTO dtoSpecies;
    private static StarshipsDTO dtoStarship;
    private static VehiclesDTO dtoVehicle;

    @BeforeAll
    static void setUp(){
       httpResponse = ConnectionManager.getConnectionResponse("https://swapi.dev/api/people/5/");
        dtoPeople = (PeopleDTO) Injection.inject("people/5/");
    }

    @Test
    @DisplayName("Connection successful")
    void connection(){
        Assertions.assertEquals(200, ConnectionManager.getStatusCode(httpResponse));
    }

    @Test
    @DisplayName("Connection successful semi-abstracted")
    void connectionManager(){
        Assertions.assertTrue(ConnectionManager.connectionIsOkay(httpResponse));
    }

    @Test
    @DisplayName("Connection successful abstracted")
    void connectionManagerAbstracted(){
        ConnectionTest.checkOkay(httpResponse);
    }

    @Test
    @DisplayName("Get headers")
    void headers(){
        System.out.println(HeadersTest.getHeaders(httpResponse));
    }

    @Test
    @DisplayName("Get number of headers")
    void numberOfHeaders(){
        System.out.println(HeadersTest.getNumberOfHeaders(httpResponse));
    }

    @Test
    @DisplayName("Check number of headers")
    void checkNumberOfHeaders(){
       HeadersTest.checkNumberOfHeaders(httpResponse);
    }

    @Test
    @DisplayName("Get server")
    void getServer(){
        System.out.println(HeadersTest.getServer(httpResponse));
    }

    @Test
    @DisplayName("Check server")
    void checkServer(){
       HeadersTest.checkServer(httpResponse);
    }

    @Test
    @DisplayName("Get date")
    void getDate(){
        System.out.println(HeadersTest.getDate(httpResponse));
    }

    @Test
    @DisplayName("Check date")
    void checkDate(){
        HeadersTest.checkDate(httpResponse);
    }

    @Test
    @DisplayName("see headers")
    void checkHeaders(){
        System.out.println(HeadersTest.getStatus(httpResponse));
        System.out.println(HeadersTest.getAllow(httpResponse));
        System.out.println(HeadersTest.getContentType(httpResponse));
        System.out.println(HeadersTest.getDate(httpResponse));
        System.out.println(HeadersTest.getEtag(httpResponse));
        System.out.println(HeadersTest.getServer(httpResponse));
        System.out.println(HeadersTest.getStrictTransportSecurity(httpResponse));
        System.out.println(HeadersTest.getVary(httpResponse));
        System.out.println(HeadersTest.getXFrameOptions(httpResponse));
    }

    @Test
    @DisplayName("Check type")
    void checkType(){
        BodyTest.checkType("PeopleDTO", dtoPeople);
    }

    @Test
    @DisplayName("Check name")
    void checkName(){
        Assertions.assertEquals("Leia Organa", dtoPeople.getName());
    }

    @Test
    @DisplayName("Check name")
    void checkHeight(){
        Assertions.assertEquals("150", dtoPeople.getHeight());
    }

}
